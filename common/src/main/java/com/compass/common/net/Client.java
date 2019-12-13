package com.compass.common.net;

import android.content.Context;

import com.compass.common.net.userauth.Callback;
import com.compass.common.net.userauth.EzHeartPackage;
import com.compass.common.net.userauth.EzPackage;
import com.compass.common.net.userauth.PackageUtil;
import com.compass.common.net.userauth.StateListener;
import com.compass.common.user.StoreHelper;
import com.ez08.eznet.client.sdk.OkSocket;
import com.ez08.eznet.client.sdk.client.ConnectionInfo;
import com.ez08.eznet.client.sdk.client.OkSocketOptions;
import com.ez08.eznet.client.sdk.client.action.SocketActionAdapter;
import com.ez08.eznet.client.sdk.client.connection.DefaultReconnectManager;
import com.ez08.eznet.client.sdk.client.connection.IConnectionManager;
import com.ez08.eznet.core.pojo.OriginalData;
import com.ez08.eznet.core.protocol.IReaderProtocol;
import com.ez08.eznet.core.utils.SLog;
import com.ez08.eznet.custom.support.EzIntent;
import com.ez08.eznet.custom.support.EzLog;
import com.ez08.eznet.custom.support.EzMessage;
import com.ez08.eznet.custom.support.EzMessageFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class Client {

    public enum STATE {
        CONNECT,
        CONNECTED,
        AUTHENTICATION,
        KICK,
        DISCONNECT
    }

    private static final String tag = "EzSocket";
    private static boolean D = true;
    public static final String ACTION_AUTH_CONNECT = "ez08.auth.connect";
    public static final String ACTION_COMMON_LOGIN = "ez08.auth.login";
    public static final String ACTION_COMMON_LOGIN_RESP = "ez08.auth.login.response";
    public static final String ACTION_COMMON_ERR = "ez08.com.response";
    public static final int ACTION_RECEIVE_HEART_SN = 0xFB;
    public static final int ACTION_RECEIVE_HEART = 0xFC;
    public static final int ACTION_RECEIVE_BIZ_SN = 0xFD;
    public static final int ACTION_RECEIVE_BIZ = 0xFE;

    public String cid;
    public String tid;
    public String token;
    public LocalInfo localInfo;

    public String ip = "202.108.13.250";
    public int port = 8081;

    public STATE state = STATE.DISCONNECT;   // 0 disconnect 1 connecting 2 connected

    private static final Hashtable<Integer, Callback> mRequestTable = new Hashtable<>();
    private static final List<StateListener> mStateListeners = new ArrayList<>();

    private Client() {
        mySocketActionAdapter = new MySocketActionAdapter();
    }

    private MySocketActionAdapter mySocketActionAdapter;

    private IConnectionManager manager;

    private static Client instance = new Client();

    public static Client getInstance() {
        return instance;
    }

    public void setLocal(LocalInfo local) {
        localInfo = local;
        EzMessageFactory.initProto();
        EzMessageFactory.AddMessageProto(localInfo.proto);
    }

    public void connect() {
        SLog.setIsDebug(true);
        sendState(STATE.CONNECT);
        ConnectionInfo info = new ConnectionInfo(ip, port);
        manager = OkSocket.open(info);
        OkSocketOptions options = manager.getOption();
        //基于当前参配对象构建一个参配建造者类
        OkSocketOptions.Builder builder = new OkSocketOptions.Builder(options);
        builder.setReadByteOrder(ByteOrder.LITTLE_ENDIAN);
        builder.setWriteByteOrder(ByteOrder.LITTLE_ENDIAN);
        builder.setPulseFrequency(30 * 1000);
        builder.setReaderProtocol(new IReaderProtocol() {
            @Override
            public int getHeaderLength() {
                return 1;
            }

            @Override
            public int getBodyLength(byte[] header, ByteOrder byteOrder) {
                return 0;
            }
        });

        builder.setReconnectionManager(new DefaultReconnectManager());
        manager.option(builder.build());
        //注册Socket行为监听器,SocketActionAdapter是回调的Simple类,其他回调方法请参阅类文档
        manager.registerReceiver(mySocketActionAdapter);
        //调用通道进行连接
        manager.connect();
    }

    private class MySocketActionAdapter extends SocketActionAdapter {
        @Override
        public void onSocketConnectionSuccess(ConnectionInfo info, String action) {
            sendState(STATE.CONNECTED);
            manager.send(PackageUtil.createConnectPackage(localInfo));
            manager.getPulseManager().setPulseSendable(new EzHeartPackage());
        }

        @Override
        public void onSocketReadResponse(ConnectionInfo info, String action, OriginalData data) {
            ByteBuffer buffer = ByteBuffer.wrap(data.getHeadBytes());
            int flag = buffer.get() & 0xFF;

            //心跳
            if (flag == ACTION_RECEIVE_HEART) {
                manager.getPulseManager().feed();
                EzLog.e(D, tag, "收到一个心跳包");
                return;
            }

            if (flag == ACTION_RECEIVE_HEART_SN || flag == ACTION_RECEIVE_BIZ_SN) {
                manager.getPulseManager().feed();
                EzLog.e(D, tag, "收到一个sn回应");
                return;
            }

            if (flag == ACTION_RECEIVE_BIZ) {
                EzIntent intent = new EzIntent(data.getBodyBytes());

                if (intent.getAction().equals(ACTION_AUTH_CONNECT)) {
                    manager.getPulseManager().pulse();
                    handleConnected(intent);
                    return;
                }

                if (intent.getAction().equals(ACTION_COMMON_ERR)) {
                    dispatchResponse(false, intent);
                    EzLog.e(D, tag, "返回通用错误:" + intent.getAction());
                }

                if (intent.getAction().equals(ACTION_COMMON_LOGIN_RESP)) {
                    EzMessage msgNew = localInfo.coder.decode(intent.toEzMessage());
                    intent = new EzIntent(msgNew);
                    EzLog.e(D, tag, "登录" + intent.toEzMessage().description());
                }

                EzLog.e(D, tag, "收到一个业务包 action:"+ intent.getAction());
                dispatchResponse(true, intent);
                return;
            }

            EzLog.e(D, tag, "收到一个未知数据包");
        }

        @Override
        public void onSocketDisconnection(ConnectionInfo info, String action, Exception e) {
            super.onSocketDisconnection(info, action, e);
            sendState(STATE.DISCONNECT, e);
        }
    }

    private void dispatchResponse(boolean success, EzIntent intent) {
        Callback callback = mRequestTable.get(intent.getSN());
        if (callback != null) {
            callback.onResult(success, intent);
            mRequestTable.remove(intent.getSN());
            manager.getPulseManager().feed();
        }
    }

    public void send(EzPackage sendable, Callback callback) {
        EzLog.e(D, tag, "发送一个请求" + sendable.getAction());
        mRequestTable.put(sendable.getSn(), callback);
        sendable.setCoder(localInfo.coder);
        manager.send(sendable);
    }

    public void registerListener(StateListener listener) {
        if (mStateListeners != null) {
            synchronized (mStateListeners) {
                if (!mStateListeners.contains(listener)) {
                    mStateListeners.add(listener);
                }
            }
        }
    }

    public void unRegisterListener(StateListener listener) {
        if (mStateListeners != null) {
            synchronized (mStateListeners) {
                mStateListeners.remove(listener);
            }
        }
    }

    private void handleConnected(EzIntent intent) {
        cid = intent.getExtraDataString("cid", "");
        tid = intent.getTID();
        token = intent.getExtraDataString("token", "");
        byte[] pkeybytes = intent.getExtraDataBytes("pkeyb");
        String str = intent.getExtraDataString("encnames", "");
        byte[] bytes = intent.getExtraDataBytes("rc4key");
        EzLog.e(D, tag, "连接成功 cid=" + cid + ";tid=" + tid + ";token=" + token);

        String[] mEncNames = null;
        if (str != null) {
            mEncNames = str.split(",");
        }

        if (bytes != null) {
            try {
                byte[] e = localInfo.coder.decodeRc4Key(pkeybytes, bytes);
                localInfo.coder.setInfomation(tid, null, null, pkeybytes, e, mEncNames);
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        }
    }

    public void logout() {
//        throwException(new LogoutException());
    }

    private void sendState(STATE state, Exception e) {
        if (e == null) {
            e = new Exception();
        }

        this.state = state;
        List<StateListener> copyData = new ArrayList<>(mStateListeners);
        Iterator<StateListener> it = copyData.iterator();
        while (it.hasNext()) {
            StateListener listener = it.next();
            switch (state) {
                case CONNECT:
                    if (listener != null)
                        listener.connect();
                    break;
                case CONNECTED:
                    if (listener != null)
                        listener.connect();
                    break;
                case AUTHENTICATION:
                    if (listener != null)
                        listener.authentication();
                    break;
                case KICK:
                    if (listener != null)
                        listener.kickOut();
                    break;
                case DISCONNECT:
                    if (listener != null)
                        listener.disconnect(e);
                    break;
            }
        }
    }

    private void sendState(STATE state) {
        sendState(state, null);
    }

//    private UserListener userListener;
//
//    public interface UserListener {
//        void callback(List<TradeUser> list);
//    }
//
//    public void setOnUserListener(UserListener userListener) {
//        this.userListener = userListener;
//    }
}

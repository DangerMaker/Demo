package com.compass.common.net;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;

import com.compass.common.net.extproto.Protocol_UserInfo;
import com.compass.common.net.extproto.Protocol_ZhiNanTong;
import com.compass.common.net.extproto.StockFinMessageProtocol;
import com.compass.common.user.User;
import com.compass.common.user.UserHelper;
import com.ez08.support.net.EzMessage;
import com.ez08.support.net.EzMessageFactory;
import com.ez08.support.net.EzNet;
import com.ez08.support.net.NetManager;
import com.ez08.support.net.NetResponseHandler;
import com.ez08.tools.IntentTools;

public class Client {
    public static String MAINAPP_NAME = "zhinantong_app";
    public static String APPUID = "zhinantong_android";
    private static Client INSTANCE;
    private static final Object sLock = new Object();

    public static Client getInstance() {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = new Client();
            }
            return INSTANCE;
        }
    }

    public void init(Application application) {
        NetManager.Init(application, MAINAPP_NAME, APPUID);
        NetManager.setChid("100001");
        EzMessageFactory.AddMessageProto(Protocol_ZhiNanTong.proto_zhinantong);
        EzMessageFactory.AddMessageProto(Protocol_UserInfo.proto_userinfo);
        EzMessageFactory.AddMessageProto(StockFinMessageProtocol.proto_znz_stockfindata);
        NetManager.setIpAndPort("180.76.183.190", 8081);

        IntentFilter filter = new IntentFilter();
        filter.addAction(NetManager.ACTION_AUTH_CONNECT);
        filter.addAction(NetManager.ACTION_AUTH_LOGIN);
        filter.addAction(NetManager.ACTION_AUTH_LOGOUT_RESPONSE);
        EzNet.regMessageHandler(receiver, filter);

        UserHelper.init(application);
    }

    public void connect(User user) {
        if (user == null) {
            NetManager.startNet(null, null, null);
        } else {
            NetManager.startNet(user.tid, user.cid, user.token);
        }
    }

    private static NetResponseHandler receiver = new NetResponseHandler() {

        @Override
        public void receive(EzMessage message) {
            if (message != null) {
                Intent intent = IntentTools.messageToIntent(message);
                String action = intent.getAction();
                if(action.equals(NetManager.ACTION_AUTH_CONNECT)){
                    User user = new User();
                    user.cid = intent.getStringExtra("cid");
                    user.tid = intent.getStringExtra("tid");
                    user.token = intent.getStringExtra("token");
                    user.current = true;
                    UserHelper.getInstance().saveUser(user);
                }
            }
        }

    };

}

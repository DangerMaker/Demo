package com.compass.common.net;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;

import com.compass.common.local.UserDatabase;
import com.compass.common.net.exception.CustomException;
import com.compass.common.user.User;
import com.compass.common.utils.MD5;
import com.ez08.support.net.EzNet;
import com.ez08.support.net.NetManager;
import com.ez08.support.net.NetResponseHandler2;
import com.ez08.tools.IntentTools;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class RemoteRepository {

    public static int RESPONSE = 1001;

    @SuppressLint("HandlerLeak")
    public static Observable<Response<User>> login(String name, String password) {
        final Intent intent = new Intent(NetManager.ACTION_AUTH_LOGIN);
        intent.putExtra("mobile", name);
        String mD5Encode = MD5.mD5Encode(password, "UTF-8");
        intent.putExtra("pwd", mD5Encode);

        return Observable.create(new ObservableOnSubscribe<Response<User>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<User>> emitter) throws Exception {
                EzNet.Request(IntentTools.intentToMessage(intent),
                        new NetResponseHandler2() {
                            @Override
                            public void receive(int i, boolean b, Intent intent) {
                                if (intent.getAction().equals(NetManager.ACTION_AUTH_LOGIN_RESPONSE)) {
                                    Response<User> response = new Response<>();
                                    response.setData(User.parser(intent));
                                    emitter.onNext(response);
                                }
                            }

                            @Override
                            public void netConnectLost(int what) {
                                emitter.onError(CustomException.throwNetworkException());
                            }

                            @Override
                            public void timeout(int what) {
                                emitter.onError(CustomException.throwNetworkException());
                            }
                        }, RESPONSE, 2, 0);
            }
        });
    }
}

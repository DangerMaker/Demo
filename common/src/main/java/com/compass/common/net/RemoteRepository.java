package com.compass.common.net;

import android.annotation.SuppressLint;
import android.util.Log;

import com.compass.common.net.exception.CustomException;
import com.compass.common.net.userauth.Callback;
import com.compass.common.net.userauth.EzPackage;
import com.compass.common.selfcode.ItemStock;
import com.compass.common.user.User;
import com.compass.common.utils.MD5;
import com.ez08.eznet.custom.support.EzIntent;
import com.ez08.eznet.custom.support.EzKeyValue;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class RemoteRepository {

    @SuppressLint("HandlerLeak")
    public static Observable<Response<User>> login(final String name, final String password) {
        return Observable.create(new ObservableOnSubscribe<Response<User>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<User>> emitter) throws Exception {
                EzIntent intent = new EzIntent("ez08.auth.login");
                intent.putExtraData(new EzKeyValue("mobile", name));
                String mD5Encode = MD5.mD5Encode(password, "UTF-8");
                intent.putExtraData(new EzKeyValue("pwd", mD5Encode));
                intent.setEncFlags(2);
                Client.getInstance().send(new EzPackage(intent), new Callback() {
                    @Override
                    public void onResult(boolean success, EzIntent intent) {
                        if (success) {
                            Response<User> response = new Response<>();
                            response.setData(User.parser(intent));
                            emitter.onNext(response);
                        } else {
                            emitter.onError(CustomException.throwCommonException(intent));
                        }
                    }
                });
            }
        });
    }

    public static Observable<Response<List<ItemStock>>> getSelfCode(){
        return Observable.create(new ObservableOnSubscribe<Response<List<ItemStock>>>() {
            @Override
            public void subscribe(final ObservableEmitter<Response<List<ItemStock>>> emitter) throws Exception {

                EzIntent intent = new EzIntent("ez08.znt.mystock3.q");
                Client.getInstance().send(new EzPackage(intent), new Callback() {
                    @Override
                    public void onResult(boolean success, EzIntent intent) {
                        if (success) {
                            Response<List<ItemStock>> response = new Response<>();
//                            response.setData(User.parser(intent));
                            Log.e("mystock3",intent.toEzMessage().description());
                            emitter.onNext(response);
                        } else {
                            emitter.onError(CustomException.throwCommonException(intent));
                        }
                    }
                });
            }
        });
    }

}


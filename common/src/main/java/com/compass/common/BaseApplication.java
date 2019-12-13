package com.compass.common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.compass.common.net.Client;
import com.compass.common.net.LocalInfo;
import com.compass.common.net.extproto.Protocol_ZhiNanTong;
import com.compass.common.utils.AppExecutors;


public class BaseApplication extends Application {

    Context mContext;

    @SuppressLint("CheckResult")
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        new AppExecutors().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                Client.getInstance().setLocal(new LocalInfo(mContext
                        , Protocol_ZhiNanTong.proto_zhinantong));
                Client.getInstance().connect();

            }
        });
    }
}

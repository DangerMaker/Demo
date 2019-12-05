package com.compass.common;

import android.annotation.SuppressLint;
import android.app.Application;

import com.compass.common.net.Client;
import com.compass.common.rx.SchedulerProvider;
import com.compass.common.user.User;
import com.compass.common.user.UserHelper;

import io.reactivex.functions.Consumer;

public class BaseApplication extends Application {


    @SuppressLint("CheckResult")
    @Override
    public void onCreate() {
        super.onCreate();
        //net init
        Client.getInstance().init(BaseApplication.this);

        UserHelper.getCurrent(getApplicationContext())
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        Client.getInstance().connect(user);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Client.getInstance().connect(null);
                    }
                });

    }
}

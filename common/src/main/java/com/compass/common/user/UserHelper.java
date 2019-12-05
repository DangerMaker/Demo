package com.compass.common.user;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.compass.common.local.UserDao;
import com.compass.common.local.UserDatabase;
import com.compass.common.net.exception.CustomException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class UserHelper {

    private static UserHelper INSTANCE;

    public static UserHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserHelper();
        }
        return INSTANCE;
    }

    private static Context context;
    private static UserDao dao;

    public static void init(Context app){
        context = app;
        dao = UserDatabase.getInstance(context).userDao();
    }

    public void saveUser(final User user){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertUser(user);
            }
        }).start();
    }


    private static UserDao getUserDao(Context context){
        return dao;
    }

    public static Observable<User> getCurrent(final Context context){
        return Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                User user = getUserDao(context).getCurrentUser();
                if(user != null) {
                    emitter.onNext(user);
                }else{
                    emitter.onError(CustomException.throwNoUserExcption());
                }
            }
        });
    }
}

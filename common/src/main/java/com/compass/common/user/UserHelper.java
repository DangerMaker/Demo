package com.compass.common.user;

import android.content.Context;

import com.compass.common.local.UserDao;
import com.compass.common.local.UserDatabase;
import com.compass.common.net.exception.CustomException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class UserHelper {

//    private static UserHelper INSTANCE;
//
//    Context mContext;
//
//    public static UserHelper getInstance(Context context) {
//        if (INSTANCE == null) {
//            INSTANCE = new UserHelper(context.getApplicationContext());
//        }
//        return INSTANCE;
//    }
//
//    private static UserDao dao;
//
//    public UserHelper(Context mContext) {
//        this.mContext = mContext;
//        dao = UserDatabase.getInstance(context).userDao();
//    }
//
//    public static void init(Context app){
//        context = app;
//
//    }
//
//    public void saveUser(final User user){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                dao.insertUser(user);
//            }
//        }).start();
//    }
//
//
//    private static UserDao getUserDao(Context context){
//        return dao;
//    }
//
//    public static Observable<User> getCurrent(final Context context){
//        return Observable.create(new ObservableOnSubscribe<User>() {
//            @Override
//            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
//                User user = getUserDao(context).getCurrentUser();
//                if(user != null) {
//                    emitter.onNext(user);
//                }else{
//                    emitter.onError(CustomException.throwNoUserExcption());
//                }
//            }
//        });
//    }
}

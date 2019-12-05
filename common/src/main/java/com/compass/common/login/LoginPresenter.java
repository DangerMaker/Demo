package com.compass.common.login;

import android.util.Log;

import com.compass.common.local.UserDao;
import com.compass.common.local.UserDatabase;
import com.compass.common.net.Response;
import com.compass.common.net.RemoteRepository;
import com.compass.common.rx.SchedulerProvider;
import com.compass.common.user.User;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class LoginPresenter implements LoginContract.Presenter {

    private CompositeDisposable mCompositeDisposable;
    private UserDatabase database;
    private SchedulerProvider scheduler;

    public LoginPresenter(UserDatabase database) {
        this.mCompositeDisposable = new CompositeDisposable();
        this.database = database;
        this.scheduler = SchedulerProvider.getInstance();
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void login(String name, String pwd) {
        Disposable disposable = RemoteRepository.login(name, pwd)
                .observeOn(SchedulerProvider.getInstance().io())
                .doOnNext(new Consumer<Response<User>>() {
                    @Override
                    public void accept(Response<User> userResponse) throws Exception {
                        UserDao dao = database.userDao();
                        dao.insertUser(userResponse.getData());
                        Log.e("database","insert");
                    }
                })
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.ui())
                .subscribe(new Consumer<Response<User>>() {
                    @Override
                    public void accept(Response<User> userResponse) {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void start() {

    }
}

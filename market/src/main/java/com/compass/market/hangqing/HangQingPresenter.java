package com.compass.market.hangqing;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.compass.common.local.UserDao;
import com.compass.common.net.NetInterface;
import com.compass.common.net.RemoteRepository;
import com.compass.common.net.Response;
import com.compass.common.rx.SchedulerProvider;
import com.compass.common.user.User;
import com.compass.market.MarketRemoteRepository;
import com.compass.market.model.HangQingResp;
import com.ez08.support.net.NetResponseHandler2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HangQingPresenter implements HangContract.Presenter {
    private CompositeDisposable mCompositeDisposable;
    private SchedulerProvider scheduler;

    @Nullable
    private final HangContract.View mHangQingView;

    public HangQingPresenter(@Nullable HangContract.View view) {
        this.mCompositeDisposable = new CompositeDisposable();
        this.scheduler = SchedulerProvider.getInstance();
        this.mHangQingView = view;
    }

    @Override
    public void getList() {
        Disposable disposable = MarketRemoteRepository.getHangqing()
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.ui())
                .subscribe(new Consumer<Response<HangQingResp>>() {
                    @Override
                    public void accept(Response<HangQingResp> userResponse) {
                        mHangQingView.setList(userResponse.getData());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.dispose();
    }
}

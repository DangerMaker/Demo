package com.compass.common.selfcode;

import android.annotation.SuppressLint;
import android.util.Log;

import com.compass.common.net.RemoteRepository;
import com.compass.common.net.Response;
import com.compass.common.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.functions.Consumer;

public class SelfCodePresenter implements SelfCodeContract.Presenter {

    SelfCodeContract.View view;
    public SelfCodePresenter(SelfCodeContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadSelfCode() {
        RemoteRepository.getSelfCode()
                .subscribeOn(SchedulerProvider.getInstance().io())
                .observeOn(SchedulerProvider.getInstance().ui())
                .subscribe(new Consumer<Response<List<ItemStock>>>() {
                    @Override
                    public void accept(Response<List<ItemStock>> listResponse) throws Exception {

                    }
                });

    }

    @Override
    public void subscribe() {
        loadSelfCode();
    }

    @Override
    public void unsubscribe() {

    }
}

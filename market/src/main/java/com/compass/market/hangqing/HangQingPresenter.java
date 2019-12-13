package com.compass.market.hangqing;

import androidx.annotation.Nullable;

import com.compass.common.net.Response;
import com.compass.common.rx.SchedulerProvider;
import com.compass.market.MarketRemoteRepository;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.StockMarketEntity;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HangQingPresenter implements HangQingContract.Presenter {
    private CompositeDisposable mCompositeDisposable;
    private SchedulerProvider scheduler;

    @Nullable
    private final HangQingContract.View mHangQingView;

    public HangQingPresenter(@Nullable HangQingContract.View view) {
        this.mCompositeDisposable = new CompositeDisposable();
        this.scheduler = SchedulerProvider.getInstance();
        this.mHangQingView = view;
    }

    @Override
    public void subscribe() {
        loadIndexs();
        loadMarkets();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void loadMarkets() {
        Disposable disposable = MarketRemoteRepository.getHangqing()
                .subscribeOn(scheduler.ui())
                .observeOn(scheduler.ui())
                .subscribe(new Consumer<Response<HangQingResp>>() {
                    @Override
                    public void accept(Response<HangQingResp> userResponse) {
                        mHangQingView.showMarkets(userResponse.getData());
//                        mHangQingView.showMarketsEmpty();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void loadIndexs() {
        Disposable disposable = MarketRemoteRepository.getStockQuery()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(new Consumer<Response<List<StockMarketEntity>>>() {
                    @Override
                    public void accept(Response<List<StockMarketEntity>> listResponse) {
                        List<StockMarketEntity> stocks = listResponse.getData();
                        mHangQingView.showIndexs(stocks);
                    }
                });
        mCompositeDisposable.add(disposable);
    }
}

package com.compass.market.hangqing;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.compass.common.base.BaseFragment;
import com.compass.market.R;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.StockMarketEntity;
import com.compass.market.view.Broad3GridView;
import com.compass.market.view.Index3GridView;
import com.compass.market.view.Index4GridView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

public class HangQingFragment extends BaseFragment implements HangQingContract.View {

    private HangQingPresenter presenter;
    private LinearLayout marketRootView;
    private Index4GridView index4GridView;
    private Index3GridView index3GridView;
    private Broad3GridView broad3UpView;
    private Broad3GridView broad3DownView;
    RefreshLayout refreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.market_fragment_hangqing;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = view.findViewById(R.id.refresh_layout);
        marketRootView = view.findViewById(R.id.market_root_view);
        index4GridView = view.findViewById(R.id.index4);
        index3GridView = view.findViewById(R.id.index3);
        broad3DownView = view.findViewById(R.id.broad3_down);
        broad3UpView = view.findViewById(R.id.broad3_up);
        presenter = new HangQingPresenter(this);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh(2000);
            }
        });
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMarkets(HangQingResp resp) {
        index3GridView.setData(resp.boardlist0);
        broad3UpView.setData(resp.boardlist1,"领涨板块");
        broad3DownView.setData(resp.boardlist2,"领跌板块");
    }

    @Override
    public void showMarketsEmpty() {
        index4GridView.setData(null);
        index3GridView.setData(null);
    }

    @Override
    public void showIndexs(List<StockMarketEntity> stocks) {
        index4GridView.setData(stocks);
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }
}

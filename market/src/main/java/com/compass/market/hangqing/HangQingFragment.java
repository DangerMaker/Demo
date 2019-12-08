package com.compass.market.hangqing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.compass.common.base.BaseFragment;
import com.compass.common.net.NetInterface;
import com.compass.market.R;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.IndexModel;
import com.compass.market.model.ItemStock;
import com.compass.market.model.StockMarketEntity;
import com.compass.market.view.Index3GridView;
import com.compass.market.view.Index4GridView;
import com.ez08.support.net.NetResponseHandler2;

import java.util.ArrayList;
import java.util.List;

public class HangQingFragment extends BaseFragment implements HangQingContract.View {

    HangQingPresenter presenter;
    LinearLayout marketRootView;
    Index4GridView index4GridView;
    Index3GridView index3GridView;

    @Override
    protected int getLayoutId() {
        return R.layout.market_fragment_hangqing;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        marketRootView = view.findViewById(R.id.market_root_view);
        index4GridView = view.findViewById(R.id.index4);
        index3GridView = view.findViewById(R.id.index3);
        presenter = new HangQingPresenter(this);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMarkets(HangQingResp resp) {
//        data.add(resp.boardlist0);
//        adapter.update(data);
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

package com.compass.market.hangqing;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.compass.common.base.BaseFragment;
import com.compass.market.R;
import com.compass.market.model.HangQingResp;
import com.compass.market.model.IndexModel;

import java.util.ArrayList;
import java.util.List;

public class HangQingFragment extends BaseFragment implements HangContract.View {

    RecyclerView recyclerView;
    HangQingPresenter presenter;
    HangQingAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.market_fragment_hangqing;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new HangQingAdapter(mContext);
        recyclerView.setAdapter(adapter);
        presenter = new HangQingPresenter(this);
        presenter.getList();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void setList(HangQingResp resp) {
        List<Object> data = new ArrayList<>();
        for (int i = 0; i < resp.boardlist0.size(); i++) {
            data.add(IndexModel.parser(resp.boardlist0.get(i)));
        }

    }

    @Override
    public void setPresenter(HangContract.Presenter presenter) {

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

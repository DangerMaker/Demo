package com.compass.common.selfcode;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.compass.common.R;
import com.compass.common.base.BaseFragment;

public class SelfCodeFragment extends BaseFragment implements SelfCodeContract.View {

    RecyclerView recyclerView;
    SelfCodeAdapter adapter;
    SelfCodePresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.common_fragment_selfcode;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new SelfCodeAdapter(mContext);
        recyclerView.setAdapter(adapter);
        presenter = new SelfCodePresenter(this);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showList(ItemStock itemStock) {

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

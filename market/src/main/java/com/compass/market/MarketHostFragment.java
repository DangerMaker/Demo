package com.compass.market;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.compass.common.base.BaseFragment;
import com.compass.market.view.CompassTabView;

public class MarketHostFragment extends BaseFragment {

    Button dayNight;
    Button search;
    CompassTabView tabView;
    @Override
    protected int getLayoutId() {
        return R.layout.market_fragment_host;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dayNight = view.findViewById(R.id.theme_style);
        search = view.findViewById(R.id.add_stock);
        tabView = view.findViewById(R.id.tab_layout);
    }
}

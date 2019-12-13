package com.compass.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.compass.common.EmptyFragment;
import com.compass.common.base.BaseActivity;
import com.compass.common.kefu.KefuFragment;
import com.compass.common.selfcode.SelfCodeFragment;
import com.compass.market.MarketHostFragment;
import com.compass.market.hangqing.HangQingFragment;
import com.compass.trade.TradeHostFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    ViewPager viewPager;
    MainAdapter mainAdapter;

    View layout1;
    View layout2;
    View layout3;
    View layout4;
    View layout5;

    int initPos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        layout1 = findViewById(R.id.layout_market);
        layout2 = findViewById(R.id.layout_news);
        layout3 = findViewById(R.id.layout_live);
        layout4 = findViewById(R.id.layout_trade);
        layout5 = findViewById(R.id.layout_kefu);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
        layout4.setOnClickListener(this);
        layout5.setOnClickListener(this);

        Fragment fragment1 = new MarketHostFragment();
        Fragment fragment2 = new SelfCodeFragment();
        Fragment fragment3 = new EmptyFragment();
        Fragment fragment4 = new EmptyFragment();
        Fragment fragment5 = new KefuFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        list.add(fragment5);


        if(savedInstanceState != null){
            initPos = savedInstanceState.getInt("pos");
            Log.e("savedInstanceState",initPos + "");
        }

        mainAdapter = new MainAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(mainAdapter);
        switchTab(initPos);
    }

    public void switchTab(int paramInt) {
        this.layout1.setSelected(false);
        this.layout2.setSelected(false);
        this.layout3.setSelected(false);
        this.layout4.setSelected(false);
        this.layout5.setSelected(false);
        this.layout1.setEnabled(true);
        this.layout2.setEnabled(true);
        this.layout3.setEnabled(true);
        this.layout4.setEnabled(true);
        this.layout5.setEnabled(true);
        View localView;
        switch (paramInt) {
            default:
                return;
            case 0:
                localView = this.layout1;
                break;
            case 1:
                localView = this.layout2;
                break;
            case 2:
                localView = this.layout3;
                break;
            case 3:
                localView = this.layout4;
                break;
            case 4:
                localView = this.layout5;
                break;
        }

        if (localView != null) {
            localView.setSelected(true);
            localView.setEnabled(true);
        }
        if (viewPager.getCurrentItem() != paramInt) {
            viewPager.setCurrentItem(paramInt,false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_market:
                switchTab(0);
                break;
            case R.id.layout_news:
                switchTab(1);
                break;
            case R.id.layout_live:
                switchTab(2);
                break;
            case R.id.layout_trade:
                switchTab(3);
                break;
            case R.id.layout_kefu:
                switchTab(4);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("pos", viewPager.getCurrentItem());
        super.onSaveInstanceState(outState);
    }
}

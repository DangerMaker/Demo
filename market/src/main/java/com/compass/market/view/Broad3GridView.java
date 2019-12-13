package com.compass.market.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.compass.market.R;
import com.compass.market.model.PlateMarketEntity;

import java.util.List;

public class Broad3GridView extends LinearLayout {

    TextView subTitleView;
    TextView allView;

    MarketBroadView broadView1;
    MarketBroadView broadView2;
    MarketBroadView broadView3;

    public Broad3GridView(Context context) {
        super(context);
    }

    public Broad3GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.market_view_broad3,this);
        subTitleView = findViewById(R.id.market_sub_title);
        allView = findViewById(R.id.market_all);
        broadView1 = findViewById(R.id.market_broad1);
        broadView2 = findViewById(R.id.market_broad2);
        broadView3 = findViewById(R.id.market_broad3);
    }

    private String sub;
    public void setData(List<PlateMarketEntity> list, String subtitle){
        sub = subtitle;
        subTitleView.setText(sub);
        if(list == null ||list.size() < 3){
            return;
        }

        broadView1.setData(list.get(0));
        broadView2.setData(list.get(1));
        broadView3.setData(list.get(2));
    }
}

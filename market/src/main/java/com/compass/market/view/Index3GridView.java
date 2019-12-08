package com.compass.market.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.compass.market.R;
import com.compass.market.model.IndexModel;

import java.util.ArrayList;
import java.util.List;

public class Index3GridView extends LinearLayout {

    List<LinearLayout> views;
    TextView subTitleView;
    TextView allView;
    String[] indexs = {"新涨跌指数", "创业板", "中小板"};


    public Index3GridView(Context context) {
        super(context);
    }

    public Index3GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.market_view_index3, this);
        views = new ArrayList<>();
        views.add((LinearLayout) findViewById(R.id.zd_layout));
        views.add((LinearLayout) findViewById(R.id.cy_layout));
        views.add((LinearLayout) findViewById(R.id.zx_layout));

        subTitleView = findViewById(R.id.market_sub_title);
        allView = findViewById(R.id.market_all);
        subTitleView.setText("指数全景监控");
    }

    public void setData(List<IndexModel> list) {
        if (list == null || list.size() < 3) {
            for (int i = 0; i < 3; i++) {
                TextView title = (TextView) views.get(i).getChildAt(0);
                TextView increase = (TextView) views.get(i).getChildAt(1);
                title.setText(indexs[i]);
                increase.setText("- -");
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                TextView title = (TextView) views.get(i).getChildAt(0);
                TextView increase = (TextView) views.get(i).getChildAt(1);
                title.setText(indexs[i]);
                increase.setText("  +0.43%");
            }
        }
    }
}

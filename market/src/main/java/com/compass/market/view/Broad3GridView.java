package com.compass.market.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.compass.market.R;
import com.compass.market.model.IndexModel;

import java.util.ArrayList;
import java.util.List;

public class Broad3GridView extends LinearLayout {

    List<LinearLayout> views;
    TextView subTitleView;
    TextView allView;

    public Broad3GridView(Context context) {
        super(context);
    }

    public Broad3GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.market_view_broad3,this);
        views = new ArrayList<>();
        views.add((LinearLayout) findViewById(R.id.market_broad_layout1));
        views.add((LinearLayout) findViewById(R.id.market_broad_layout2));
        views.add((LinearLayout) findViewById(R.id.market_broad_layout3));

        subTitleView = findViewById(R.id.market_sub_title);
        allView = findViewById(R.id.market_all);
    }

    private String sub;
    public void setData(List<IndexModel> list,String subtitle){
        sub = subtitle;
        subTitleView.setText(sub);
        if(list == null ||list.size() < 3){
            return;
        }
        for (int i = 0; i < list.size(); i++) {
           TextView title =  (TextView) views.get(i).getChildAt(0);
           TextView middle = (TextView) views.get(i).getChildAt(1);
           TextView increase =  (TextView) views.get(i).getChildAt(2);

           title.setText(list.get(i).title);
           increase.setText("  +0.43%");
        }
    }
}

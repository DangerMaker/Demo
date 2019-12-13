package com.compass.market.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.compass.common.utils.CalculateUtil;
import com.compass.common.utils.ColorUtil;
import com.compass.market.R;
import com.compass.market.model.PlateMarketEntity;

import java.util.ArrayList;
import java.util.List;

public class Index3GridView extends LinearLayout {

    List<LinearLayout> views;
    TextView subTitleView;
    TextView allView;
    String[] indexs = {"新涨跌指数", "创业板", "中小板"};


    Context mContext;

    public Index3GridView(Context context) {
        super(context);
    }

    public Index3GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = getContext();
        inflate(context, R.layout.market_view_index3, this);
        views = new ArrayList<>();
        views.add((LinearLayout) findViewById(R.id.zd_layout));
        views.add((LinearLayout) findViewById(R.id.cy_layout));
        views.add((LinearLayout) findViewById(R.id.zx_layout));

        subTitleView = findViewById(R.id.market_sub_title);
        allView = findViewById(R.id.market_all);
        subTitleView.setText("指数全景监控");
    }

    public void setData(List<PlateMarketEntity> list) {
        if (list == null || list.size() < 3) {
            for (int i = 0; i < 3; i++) {
                TextView title = (TextView) views.get(i).getChildAt(0);
                TextView increase = (TextView) views.get(i).getChildAt(1);
                title.setText(indexs[i]);
                increase.setText("- -");
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                PlateMarketEntity entity = list.get(i);

                TextView title = (TextView) views.get(i).getChildAt(0);
                TextView increase = (TextView) views.get(i).getChildAt(1);
                title.setText(indexs[i]);

                float lastFloat = CalculateUtil.decm(entity.getLastclose(), entity.getExp());
                float currentFloat = CalculateUtil.decm(entity.getCurrent(), entity.getExp());
                float upValue = currentFloat - lastFloat;
                float upPercent = upValue * 100 / lastFloat * 100 / 100;
                String prefix = CalculateUtil.prefix(currentFloat, lastFloat);

                int color = ColorUtil.compare(currentFloat, lastFloat);
                title.setTextColor(ContextCompat.getColor(mContext, R.color.common_stock_name));
                increase.setTextColor(ContextCompat.getColor(mContext, color));
                increase.setText(prefix + String.format("%.2f", upPercent) + "%");
            }
        }
    }
}

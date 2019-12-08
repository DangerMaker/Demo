package com.compass.market.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.compass.common.utils.CalculateUtil;
import com.compass.common.utils.ColorUtil;
import com.compass.market.R;
import com.compass.market.model.StockMarketEntity;

import java.util.ArrayList;
import java.util.List;

public class Index4GridView extends LinearLayout {

    List<LinearLayout> views;
    String[] indexs = {"上证指数", "深证成指", "创业板指", "中小板指"};
    Context mContext;

    public Index4GridView(Context context) {
        super(context);
    }

    public Index4GridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.market_view_index4, this);
        mContext = context;
        views = new ArrayList<>();
        views.add((LinearLayout) findViewById(R.id.sh_layout));
        views.add((LinearLayout) findViewById(R.id.sz_layout));
        views.add((LinearLayout) findViewById(R.id.cy_layout));
        views.add((LinearLayout) findViewById(R.id.zxbz_layout));
    }

    public void setData(List<StockMarketEntity> list) {
        if (list == null || list.size() < 4) {
            for (int i = 0; i < 4; i++) {
                TextView title = (TextView) views.get(i).getChildAt(0);
                TextView price = (TextView) views.get(i).getChildAt(1);
                TextView increase = (TextView) views.get(i).getChildAt(2);
                title.setText(indexs[i]);
                price.setText("- -");
                increase.setText("- -");
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                TextView title = (TextView) views.get(i).getChildAt(0);
                TextView price = (TextView) views.get(i).getChildAt(1);
                TextView increase = (TextView) views.get(i).getChildAt(2);
                StockMarketEntity entity = list.get(i);
                float lastFloat = CalculateUtil.decm(entity.getLastclose(), entity.getExp());
                float currentFloat = CalculateUtil.decm(entity.getCurrent(), entity.getExp());
                int color = ColorUtil.compare(currentFloat, lastFloat);
                float upValue = currentFloat - lastFloat;
                float upPercent = upValue * 100 / lastFloat * 100 /100;

                title.setTextColor(ContextCompat.getColor(mContext, R.color.common_stock_name));
                price.setTextColor(ContextCompat.getColor(mContext, color));
                increase.setTextColor(ContextCompat.getColor(mContext,color));

                String prefix = CalculateUtil.prefix(currentFloat,lastFloat);

                title.setText(indexs[i]);
                price.setText(String.format("%.2f", currentFloat));
                increase.setText(prefix + String.format("%.2f",upValue) + "  " + prefix + String.format("%.2f",upPercent) + "%");
            }
        }
    }
}

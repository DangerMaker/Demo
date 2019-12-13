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

public class MarketBroadView extends LinearLayout {
    Context mContext;

    TextView title;
    TextView percent;
    TextView firstName;
    TextView firstPercent;

    public MarketBroadView(Context context) {
        super(context);
    }

    public MarketBroadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = getContext();
        inflate(context, R.layout.market_view_borad, this);
        title = findViewById(R.id.market_broad_name);
        percent = findViewById(R.id.market_broad_value);
        firstName = findViewById(R.id.market_board_first_name);
        firstPercent = findViewById(R.id.market_board_first_percent);
    }

    public void setData(PlateMarketEntity entity) {
        float lastFloat = CalculateUtil.decm(entity.getLastclose(), entity.getExp());
        float currentFloat = CalculateUtil.decm(entity.getCurrent(), entity.getExp());
        float upValue = currentFloat - lastFloat;
        float upPercent = upValue * 100 / lastFloat * 100 / 100;
        String prefix = CalculateUtil.prefix(currentFloat, lastFloat);
        int color = ColorUtil.compare(currentFloat, lastFloat);

        title.setTextColor(ContextCompat.getColor(mContext, R.color.common_stock_name));
        percent.setTextColor(ContextCompat.getColor(mContext, color));
        firstName.setTextColor(ContextCompat.getColor(mContext, R.color.common_stock_name));

        title.setText(entity.getBoardname());
        percent.setText(prefix + String.format("%.2f", upPercent) + "%");
        firstName.setText(entity.getFirststockname());
        firstPercent.setText(prefix + String.format("%.2f", entity.getFirststockzf() / 100f) + "%");
    }

}

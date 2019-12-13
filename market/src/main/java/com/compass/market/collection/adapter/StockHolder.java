package com.compass.market.collection.adapter;

import android.view.ViewGroup;

import com.compass.common.base.BaseViewHolder;
import com.compass.market.R;
import com.compass.market.collection.StockModel;

public class StockHolder extends BaseViewHolder<StockModel> {
    public StockHolder(ViewGroup itemView) {
        super(itemView, R.layout.market_holder_stock);
    }
}

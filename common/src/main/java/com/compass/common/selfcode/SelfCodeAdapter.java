package com.compass.common.selfcode;

import android.content.Context;
import android.view.ViewGroup;

import com.compass.common.R;
import com.compass.common.base.BaseAdapter;
import com.compass.common.base.BaseViewHolder;

public class SelfCodeAdapter extends BaseAdapter<ItemStock> {

    public SelfCodeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(parent);
    }


    public static class ItemHolder extends BaseViewHolder<ItemStock>{

        public ItemHolder(ViewGroup itemView) {
            super(itemView, R.layout.common_holder_selfcode);
        }
    }
}

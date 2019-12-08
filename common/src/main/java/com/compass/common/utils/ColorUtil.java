package com.compass.common.utils;

import androidx.core.content.ContextCompat;

import com.compass.common.R;

public class ColorUtil {

    public static int compare(float first,float second){
        if(first > second){
            return R.color.common_stock_red;
        }else if(first < second){
            return R.color.common_stock_green;
        }else {
            return R.color.common_stock_close;
        }
    }
}

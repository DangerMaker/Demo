package com.compass.common.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

public class ScreenUtil {
    public static float getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static float getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static float spToPx(Context context, float spValue) {
        if (context == null) {
            return -1.0F;
        }
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * fontScale + 0.5F;
    }

    public static float dpToPx(Context context, float dp) {
        if (context == null) {
            return -1.0F;
        }
        return dp * context.getResources().getDisplayMetrics().density;
    }
}

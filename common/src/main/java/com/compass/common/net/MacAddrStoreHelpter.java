package com.compass.common.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.UUID;

public class MacAddrStoreHelpter {

    public static String getMacAddress(Context context) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences("user_info", 0);
        String mac = mSharedPreferences.getString("mac", "");
        if(TextUtils.isEmpty(mac)){
            UUID uuid = UUID.randomUUID();
            String uuString = uuid.toString();
            setMacAddress(context,uuString);
            mac = uuString;
        }
        return mac;
    }

    private static void setMacAddress(Context context, String mac) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences("user_info", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("mac", mac);
        editor.commit();
    }
}

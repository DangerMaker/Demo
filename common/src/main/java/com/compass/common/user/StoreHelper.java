package com.compass.common.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.compass.common.net.userauth.UserInfo;

import java.util.UUID;

public class StoreHelper {

    public static UserInfo getUserInfo(Context context) {
        UserInfo userInfo = new UserInfo();
        SharedPreferences mSharedPreferences = context.getSharedPreferences("user_info", 0);
        userInfo.cid = mSharedPreferences.getString("cid", null);
        userInfo.tid = mSharedPreferences.getString("tid", null);
        userInfo.token = mSharedPreferences.getString("token", null);
        return userInfo;
    }

    public static void setUserInfo(Context context, String cid, String tid, String token) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences("user_info", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("cid", cid);
        editor.putString("tid", tid);
        editor.putString("token", token);
        editor.commit();
    }


}

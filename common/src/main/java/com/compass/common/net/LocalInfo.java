package com.compass.common.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.compass.common.local.UserDatabase;
import com.compass.common.user.User;
import com.ez08.eznet.custom.support.EzCoder;

public class LocalInfo {

    public LocalInfo(Context context, String proto) {
        coder = new EzCoder(0);
        coder.generateLocalKey();
        pkeya = coder.getPublicKeyA();

        version = getVersionName(context);
        os = "android";
        osVersion = Build.MODEL + "," + Build.VERSION.RELEASE;
        netMangerVersion = "1.0";
        appName = "zhinantong_app";
        appuid = "zhinantong_android";
        chid = "100001";
        wifiMacAddr = MacAddrStoreHelpter.getMacAddress(context);
        this.proto = proto;

        User user = UserDatabase.getInstance(context).userDao().getCurrentUser();
        if(user != null) {
            cid = user.cid;
            tid = user.tid;
            token = user.token;
        }
    }

    public String proto;
    public EzCoder coder;
    public String version;
    public String os;
    public String osVersion;
    public String netMangerVersion;
    public String appName;
    public String appuid;
    public String chid;
    public String tid;
    public String cid;
    public String token;
    public String wifiMacAddr;
    public byte[] pkeya;

    /**
     * 获取版本名称
     *
     * @param context 上下文
     * @return 版本名称
     */
    public static String getVersionName(Context context) {

        //获取包管理器
        PackageManager pm = context.getPackageManager();
        //获取包信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //返回版本号
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

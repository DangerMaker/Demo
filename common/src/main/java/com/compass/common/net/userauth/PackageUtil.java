package com.compass.common.net.userauth;

import com.compass.common.net.LocalInfo;
import com.ez08.eznet.custom.support.EzCoder;
import com.ez08.eznet.custom.support.EzIntent;
import com.ez08.eznet.custom.support.EzKeyValue;
import com.ez08.eznet.custom.support.EzLog;


public class PackageUtil {

     public static EzConnectPackage createConnectPackage(LocalInfo info) {
        EzIntent intent = new EzIntent("ez08.auth.connect");
        intent.putExtraData(new EzKeyValue("version", info.version));
        intent.putExtraData(new EzKeyValue("os", info.os));
        intent.putExtraData(new EzKeyValue("osVersion", info.osVersion));
        intent.putExtraData(new EzKeyValue("appName", info.appName));
        intent.putExtraData(new EzKeyValue("appuid", info.appuid));
        intent.putExtraData(new EzKeyValue("chid", info.chid));
        intent.putExtraData(new EzKeyValue("wifiMacAddr", info.wifiMacAddr));
        intent.putExtraData(new EzKeyValue("pkeya", info.pkeya));
        intent.putExtraData(new EzKeyValue("NetMangerVersion", info.netMangerVersion));

        if(info.token != null) {
            intent.setTID(info.tid);
            intent.setCID(info.cid);
            intent.putExtraData(new EzKeyValue("token", info.token));
        }

         return new EzConnectPackage(intent);
    }
}

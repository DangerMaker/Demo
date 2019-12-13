package com.compass.common.net.userauth;

import com.ez08.eznet.core.iocore.interfaces.IPulseSendable;
import com.ez08.eznet.custom.support.EzLog;

public class EzHeartPackage implements IPulseSendable {

    @Override
    public byte[] parse() {
        EzLog.e(true, "EzSocket", "发送一个心跳包");
        return new byte[]{(byte) 0xFC};
    }
}

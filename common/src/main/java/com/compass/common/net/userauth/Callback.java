package com.compass.common.net.userauth;

import com.ez08.eznet.custom.support.EzIntent;

public interface Callback {
    void onResult(boolean success, EzIntent intent);
}

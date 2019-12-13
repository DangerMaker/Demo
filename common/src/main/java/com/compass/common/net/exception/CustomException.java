package com.compass.common.net.exception;

import android.app.Application;

import com.ez08.eznet.custom.support.EzIntent;

public class CustomException {

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;

    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;

    /**
     * 网络错误
     */
    public static final int NETWORK_ERROR = 1002;

    /**
     * 协议错误
     */
    public static final int HTTP_ERROR = 1003;

    public static final int USER_ERROR = 1005;

    public static ApiException throwNetworkException() {
        return new ApiException(NETWORK_ERROR, "我是网络异常");
    }

    public static ApiException throwNoUserExcption() {
        return new ApiException(USER_ERROR, "我什么也不是");
    }

    public static ApiException throwCommonException(EzIntent intent) {
        String reqaction = intent.getExtraDataString("reqaction", "");
        boolean result = intent.getExtraDataBoolean("result", false);
        int errcode = intent.getExtraDataInt32("errcode", 0);
        String msg = intent.getExtraDataString("msg", "");
        return new ApiException(errcode, msg);
    }

    public static ApiException handleException(Throwable e) {
        ApiException ex;
//        if (e instanceof JsonParseException
//                || e instanceof JSONException
//                || e instanceof ParseException) {
//            //解析错误
//            ex = new ApiException(PARSE_ERROR, e.getMessage());
//            return ex;
//        } else if (e instanceof ConnectException) {
//            //网络错误
//            ex = new ApiException(NETWORK_ERROR, e.getMessage());
//            return ex;
//        } else if (e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
//            //连接错误
        ex = new ApiException(NETWORK_ERROR, e.getMessage());
//            return ex;
//        } else {
//            //未知错误
//            ex = new ApiException(UNKNOWN, e.getMessage());
        return ex;
//        }
    }
}
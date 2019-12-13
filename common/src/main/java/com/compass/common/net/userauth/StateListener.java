package com.compass.common.net.userauth;

public interface StateListener {
    //连接中
    void connect();
    //已连接
    void conected();
    //已认证
    void authentication();
    //被踢出
    void kickOut();
    //异常引起断开重连
    void disconnect(Exception e);

}

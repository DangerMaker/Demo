package com.compass.common.net;

public class Response<T> {

    private int ret; // 返回的code
    private T data; // 具体的数据结果
    private String action; // message 可用来返回接口的说明

    public int getCode() {
        return ret;
    }

    public void setCode(int code) {
        this.ret = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
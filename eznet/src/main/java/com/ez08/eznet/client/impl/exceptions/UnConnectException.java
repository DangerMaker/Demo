package com.ez08.eznet.client.impl.exceptions;

/**
 * Created by xuhao on 2017/5/16.
 */

public class UnConnectException extends RuntimeException {
    public UnConnectException() {
        super();
    }

    public UnConnectException(String message) {
        super(message);
    }

    public UnConnectException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnConnectException(Throwable cause) {
        super(cause);
    }

}

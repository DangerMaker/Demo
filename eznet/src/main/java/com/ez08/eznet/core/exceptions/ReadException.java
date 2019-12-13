package com.ez08.eznet.core.exceptions;

/**
 * 读异常
 * Created by xuhao on 2017/5/16.
 */

public class ReadException extends RuntimeException {
    public ReadException() {
        super();
    }

    public ReadException(String message) {
        super(message);
    }

    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadException(Throwable cause) {
        super(cause);
    }
}

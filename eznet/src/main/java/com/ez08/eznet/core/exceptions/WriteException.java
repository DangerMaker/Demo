package com.ez08.eznet.core.exceptions;

/**
 * 写异常
 * Created by xuhao on 2017/5/16.
 */

public class WriteException extends RuntimeException {
    public WriteException() {
        super();
    }

    public WriteException(String message) {
        super(message);
    }

    public WriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteException(Throwable cause) {
        super(cause);
    }

}

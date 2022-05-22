package com.yun.rpc.core.exception;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 18:24
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}

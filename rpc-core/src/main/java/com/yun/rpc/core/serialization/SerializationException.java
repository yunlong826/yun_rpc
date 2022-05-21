package com.yun.rpc.core.serialization;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/21 18:54
 */
public class SerializationException extends RuntimeException{
    public SerializationException(){
        super();
    }
    public SerializationException(String msg){
        super(msg);
    }
    public SerializationException(String msg,Throwable cause){
        super(msg,cause);
    }
    public SerializationException(Throwable cause){
        super(cause);
    }
}

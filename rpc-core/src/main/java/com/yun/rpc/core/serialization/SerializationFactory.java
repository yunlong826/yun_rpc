package com.yun.rpc.core.serialization;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/21 19:00
 */
public class SerializationFactory {
    public static RpcSerialization getRpcSerialization(SerializationTypeEnum typeEnum){
        switch(typeEnum){
            case HESSIAN:
                return new HessianSerialization();
            case JSON:
                return new JsonSerialization();
            default:
                throw new IllegalArgumentException("serialization type is illegal");
        }
    }
}

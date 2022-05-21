package com.yun.rpc.core.serialization;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/21 18:42
 */
public interface RpcSerialization {
    <T> byte[] serialize(T obj) throws Exception;

    <T> T deserialize(byte[] data,Class<T> clz) throws Exception;
}

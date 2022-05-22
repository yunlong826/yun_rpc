package com.yun.rpc.server.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 将暴露的服务缓存到本地 在处理 RPC 请求时可以直接通过 cache 拿到对应的服务进行调用。避免反射实例化服务开销
 * @date 2022/5/22 14:07
 */
public class LocalServerCache {
    private static final Map<String,Object> serverCacheMap = new HashMap<>();
    public static void store(String serverName,Object server){
        serverCacheMap.merge(serverName,server,(Object oldObject,Object newObj)->newObj);
    }
    public static Object get(String serverName){
        return serverCacheMap.get(serverName);
    }
    public static Map<String,Object> getAll(){
        return null;
    }
}

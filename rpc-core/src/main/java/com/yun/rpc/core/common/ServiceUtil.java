package com.yun.rpc.core.common;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 14:55
 */
public class ServiceUtil {
    /**
     *
     * @param serviceName
     * @param version
     * @return
     */
    public static String serviceKey(String serviceName, String version) {
        return String.join("-", serviceName, version);
    }
}

package com.yun.rpc.core.discovery;

import com.yun.rpc.core.common.ServiceInfo;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 服务发现
 * @date 2022/5/21 16:47
 */
public interface DiscoveryService {

    /**
     *
     *
     * @param serviceName 
     * @return com.yun.rpc.core.common.ServiceInfo 
     * @author long_yun
     * @date 2022/5/21 16:49
     * @describe 服务的发现
     */
    
    ServiceInfo discovery(String serviceName) throws Exception;
}

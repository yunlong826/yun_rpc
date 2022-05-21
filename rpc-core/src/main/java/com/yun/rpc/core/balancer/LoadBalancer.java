package com.yun.rpc.core.balancer;

import com.yun.rpc.core.common.ServiceInfo;

import java.util.List;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 负载均衡算法接口
 * @date 2022/5/21 13:31
 */
public interface LoadBalancer {

    /**
     *
     *
     * @param services 
     * @return com.yun.rpc.core.common.ServiceInfo 
     * @author long_yun
     * @date 2022/5/21 16:16 
     */
    
    ServiceInfo chooseOne(List<ServiceInfo> services);

}

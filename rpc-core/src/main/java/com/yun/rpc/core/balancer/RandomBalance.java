package com.yun.rpc.core.balancer;

import com.yun.rpc.core.common.ServiceInfo;

import java.util.List;
import java.util.Random;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 随机算法
 * @date 2022/5/21 16:23
 */
public class RandomBalance implements LoadBalancer{
    private static Random random = new Random();
    @Override
    public ServiceInfo chooseOne(List<ServiceInfo> services) {
        return services.get(random.nextInt(services.size()));
    }
}

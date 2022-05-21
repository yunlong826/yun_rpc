package com.yun.rpc.core.balancer;

import com.yun.rpc.core.common.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 轮询算法
 * @date 2022/5/21 16:19
 */
public class FullRoundBalance implements LoadBalancer{
    private static Logger logger = LoggerFactory.getLogger(FullRoundBalance.class);
    private int index;
    @Override
    public synchronized ServiceInfo chooseOne(List<ServiceInfo> services) {
        // 加锁防止多线程情况下，index超出services.size()
        if(index >= services.size()){
            index = 0;
        }
        return services.get(index++);
    }
}

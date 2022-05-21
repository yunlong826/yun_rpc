package com.yun.rpc.core.discovery;

import com.yun.rpc.core.balancer.LoadBalancer;
import com.yun.rpc.core.common.ServiceInfo;
import com.yun.rpc.core.register.ZookeeperRegistryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/21 16:49
 */
@Slf4j
public class ZookeeperDiscoveryService implements DiscoveryService{
    public static final int BASE_SLEEP_TIME_MS = 1000;
    public static final int MAX_RETRIES = 3;
    public static final String ZK_BASE_PATH = "/demp_rpc";

    private ServiceDiscovery<ServiceInfo> serviceDiscovery;

    private LoadBalancer loadBalancer;

    public ZookeeperDiscoveryService(String registryAddr,LoadBalancer loadBalancer){
        this.loadBalancer = loadBalancer;
        try{
            CuratorFramework client = CuratorFrameworkFactory.newClient(registryAddr,new ExponentialBackoffRetry(BASE_SLEEP_TIME_MS,MAX_RETRIES));
            client.start();
            JsonInstanceSerializer<ServiceInfo> serializer = new JsonInstanceSerializer<>(ServiceInfo.class);
            this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceInfo.class)
                    .client(client)
                    .serializer(serializer)
                    .basePath(ZK_BASE_PATH)
                    .build();
            this.serviceDiscovery.start();
        }catch (Exception e){
            log.error("serviceDiscovery start error :{}",e);
        }
    }

    /**
     *
     *
     * @param serviceName
     * @return com.yun.rpc.core.common.ServiceInfo
     * @author long_yun
     * @date 2022/5/21 16:56
     * @describe 服务的发现
     */

    @Override
    public ServiceInfo discovery(String serviceName) throws Exception {
        Collection<ServiceInstance<ServiceInfo>> serviceInstances = serviceDiscovery.queryForInstances(serviceName);
        return CollectionUtils.isEmpty(serviceInstances)?null
                : loadBalancer.chooseOne(serviceInstances.stream().map(ServiceInstance::getPayload).collect(Collectors.toList()));
    }

}

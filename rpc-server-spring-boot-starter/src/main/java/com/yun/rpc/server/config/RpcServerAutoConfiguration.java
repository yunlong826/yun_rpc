package com.yun.rpc.server.config;

import com.yun.rpc.core.register.RegistryService;
import com.yun.rpc.core.register.ZookeeperRegistryService;
import com.yun.rpc.server.RpcServerProvider;
import com.yun.rpc.server.transport.NettyRpcServer;
import com.yun.rpc.server.transport.RpcServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO rpc server 配置
 * @date 2022/5/22 14:36
 */
@Configuration
@EnableConfigurationProperties(RpcServerProperties.class)
public class RpcServerAutoConfiguration {
    @Autowired
    private RpcServerProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public RegistryService registryService(){
        return new ZookeeperRegistryService(properties.getRegistryAddr());
    }

    @Bean
    @ConditionalOnMissingBean(RpcServer.class)
    RpcServer RpcServer(){
        return new NettyRpcServer();
    }

    @Bean
    @ConditionalOnMissingBean(RpcServerProperties.class)
    RpcServerProvider rpcServerProvider(@Autowired RegistryService registryService,
                                        @Autowired RpcServer rpcServer,
                                        @Autowired RpcServerProperties rpcServerProperties){
        return new RpcServerProvider(registryService,rpcServer,rpcServerProperties);
    }
}

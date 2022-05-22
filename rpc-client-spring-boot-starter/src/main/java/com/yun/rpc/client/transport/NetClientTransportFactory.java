package com.yun.rpc.client.transport;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 18:33
 */
@Slf4j
public class NetClientTransportFactory {
    public static NetClientTransport getNetClientTransport(){
        return new NettyNetClientTransport();
    }
}

package com.yun.rpc.client.transport;

import com.yun.rpc.core.common.RpcResponse;
import com.yun.rpc.core.protocol.MessageProtocol;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 网络传输层
 * @date 2022/5/22 18:30
 */
public interface NetClientTransport {
    /**
     *  发送数据
     * @param metadata
     * @return
     * @throws Exception
     */
    MessageProtocol<RpcResponse> sendRequest(RequestMetadata metadata) throws Exception;
}

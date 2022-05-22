package com.yun.rpc.client.handler;

import com.yun.rpc.client.cache.LocalRpcResponseCache;
import com.yun.rpc.client.transport.RpcFuture;
import com.yun.rpc.core.common.RpcResponse;
import com.yun.rpc.core.protocol.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 18:17
 */
public class RpcResponseHandler extends SimpleChannelInboundHandler<MessageProtocol<RpcResponse>> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol<RpcResponse> rpcResponseMessageProtocol) throws Exception {
        String requestId = rpcResponseMessageProtocol.getHeader().getRequestId();
        // 收到响应 设置响应数据
        LocalRpcResponseCache.fillResponse(requestId, rpcResponseMessageProtocol);
    }
}

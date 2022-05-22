package com.yun.rpc.core.code;

import com.yun.rpc.core.protocol.MessageHeader;
import com.yun.rpc.core.protocol.MessageProtocol;
import com.yun.rpc.core.serialization.RpcSerialization;
import com.yun.rpc.core.serialization.SerializationFactory;
import com.yun.rpc.core.serialization.SerializationTypeEnum;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 编码
 * @date 2022/5/22 12:35
 */
@Slf4j
public class RpcEncoder<T> extends MessageToByteEncoder<MessageProtocol<T>> {
    /**
     *
     *  +---------------------------------------------------------------+
     *  | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte|
     *  +---------------------------------------------------------------+
     *  | 状态 1byte |        消息 ID 32byte     |      数据长度 4byte    |
     *  +---------------------------------------------------------------+
     *  |                   数据内容 （长度不定）                         |
     *  +---------------------------------------------------------------+
     *
     *
     * @param channelHandlerContext
     * @param tMessageProtocol
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol<T> tMessageProtocol, ByteBuf byteBuf) throws Exception {
        MessageHeader header = tMessageProtocol.getHeader();
        // 魔数
        byteBuf.writeShort(header.getMagic());

        // 协议版本号
        byteBuf.writeByte(header.getVersion());

        // 序列化算法
        byteBuf.writeByte(header.getSerialization());

        // 报文类型
        byteBuf.writeByte(header.getMsgType());

        // 状态
        byteBuf.writeByte(header.getStatus());

        // 消息 ID
        byteBuf.writeCharSequence(header.getRequestId(), Charset.forName("UTF-8"));

        RpcSerialization rpcSerialization = SerializationFactory.getRpcSerialization(SerializationTypeEnum.parseByType(header.getSerialization()));
        byte[] data = rpcSerialization.serialize(tMessageProtocol.getBody());
        // 数据长度
        byteBuf.writeInt(data.length);
        // 数据内容
        byteBuf.writeBytes(data);
    }
}

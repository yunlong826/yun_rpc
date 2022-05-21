package com.yun.rpc.core.protocol;

import com.yun.rpc.core.serialization.SerializationTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 消息头
 * @date 2022/5/21 18:03
 */
@Data
public class MessageHeader implements Serializable {
    /*
    +---------------------------------------------------------------+
    | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
    +---------------------------------------------------------------+
    | 状态 1byte |        消息 ID 32byte     |      数据长度 4byte     |
    +---------------------------------------------------------------+
    */

    /*
     *
     *
     * @param null 
     * @return null 
     * @author long_yun
     * @date 2022/5/21 18:04 
     * @describe 魔数
     */
    private short magic;
    
    /*
     *
     *
     * @param null 
     * @return null 
     * @author long_yun
     * @date 2022/5/21 18:05 
     * @describe 协议版本号
     */
    private byte version;

    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 18:15
     * @describe 序列化算法
     */

    private byte serialization;
    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 18:05
     * @describe 报文类型
     */
    private byte msgType;

    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 18:06
     * @describe 状态
     */
    private byte status;
    
    /*
     *
     *
     * @param null 
     * @return null 
     * @author long_yun
     * @date 2022/5/21 18:06
     * @describe 消息ID
     */
    private String requestId;

    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 18:06
     * @describe 数据长度
     */
    private int msgLen;

    public static MessageHeader build(String serialization){
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setMagic(ProtocolConstants.MAGIC);
        messageHeader.setVersion(ProtocolConstants.VERSION);
        messageHeader.setRequestId(UUID.randomUUID().toString().replaceAll("-",""));
        messageHeader.setMsgType(MsgType.REQUEST.getType());
        messageHeader.setSerialization(SerializationTypeEnum.parseByName(serialization).getType());
        return messageHeader;
    }

    

    
    
}

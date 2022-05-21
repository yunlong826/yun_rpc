package com.yun.rpc.core.protocol;

import java.io.Serializable;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 消息协议
 * @date 2022/5/21 19:08
 */
public class MessageProtocol<T> implements Serializable {
    /*
     *
     *
     * @param null
     * @return null
     * @author long_yun
     * @date 2022/5/21 19:08
     * @describe 消息头
     */
    private MessageHeader header;
    
    /*
     *
     *
     * @param null 
     * @return null 
     * @author long_yun
     * @date 2022/5/21 19:09
     * @describe 消息体
     */
    private T body;
    
}

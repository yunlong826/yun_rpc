package com.yun.rpc.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO
 * @date 2022/5/22 12:52
 */
@Data
public class RpcResponse implements Serializable {
    private Object data;
    private String message;
}

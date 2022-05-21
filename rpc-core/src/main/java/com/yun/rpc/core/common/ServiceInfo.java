package com.yun.rpc.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jack_yun
 * @version 1.0
 * @description: 暴露服务的相关信息
 * @date 2022/5/21 16:12
 */
@Data
public class ServiceInfo implements Serializable {
    /**
     *
     * 应用名称
     */
    private String appName;

    /**
     *
     * 服务名称
     */
    private String serviceName;

    /**
     *
     * 版本
     */
    private String version;

    /**
     *
     * 地址
     */
    private String address;

    /**
     *
     * 端口
     */
    private Integer port;
}

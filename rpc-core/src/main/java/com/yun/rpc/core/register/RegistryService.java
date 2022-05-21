package com.yun.rpc.core.register;

import com.yun.rpc.core.common.ServiceInfo;

import java.io.IOException;

/**
 * @author jack_yun
 * @version 1.0
 * @description: TODO 服务注册接口
 * @date 2022/5/21 16:32
 */
public interface RegistryService {
    /**
     *
     *
     * @param serviceInfo
     * @return void
     * @author long_yun
     * @date 2022/5/21 16:36
     * @describe 服务的注册
     */

    void register(ServiceInfo serviceInfo) throws Exception;

    /**
     *
     *
     * @param serviceInfo
     * @return void
     * @author long_yun
     * @date 2022/5/21 16:37
     * @describe 服务的卸载
     */

    void unRegister(ServiceInfo serviceInfo) throws Exception;

    /**
     *
     *

     * @return void
     * @author long_yun
     * @date 2022/5/21 16:37
     * @describe 服务的销毁
     */

    void destroy() throws IOException;
}

package com.yun.rpc.server.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 *
 *
 * @author long_yun
 * @date 2022/5/22 13:05
 * @describe 暴露服务注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface RpcService {
    /**
     *  暴露服务接口类型
     * @return
     */
    Class<?> interfaceType() default Object.class;

    /**
     *  服务版本
     * @return
     */
    String version() default "1.0";
}

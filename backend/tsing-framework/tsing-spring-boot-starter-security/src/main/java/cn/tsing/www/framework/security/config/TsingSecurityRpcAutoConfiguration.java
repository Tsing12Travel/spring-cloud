package cn.tsing.www.framework.security.config;

import cn.tsing.www.framework.security.core.rpc.LoginUserRequestInterceptor;
import cn.tsing.www.module.system.api.oauth2.OAuth2TokenApi;
import cn.tsing.www.module.system.api.permission.PermissionApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Security 使用到 Feign 的配置项
 *
 * @author 芋道源码
 */
@AutoConfiguration
@EnableFeignClients(clients = {OAuth2TokenApi.class, // 主要是引入相关的 API 服务
        PermissionApi.class})
public class TsingSecurityRpcAutoConfiguration {

    @Bean
    public LoginUserRequestInterceptor loginUserRequestInterceptor() {
        return new LoginUserRequestInterceptor();
    }

}

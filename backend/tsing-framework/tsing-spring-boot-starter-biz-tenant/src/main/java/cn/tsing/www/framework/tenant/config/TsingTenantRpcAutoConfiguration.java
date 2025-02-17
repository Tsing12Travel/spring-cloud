package cn.tsing.www.framework.tenant.config;

import cn.tsing.www.framework.tenant.core.rpc.TenantRequestInterceptor;
import cn.tsing.www.module.system.api.tenant.TenantApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AutoConfiguration
@ConditionalOnProperty(prefix = "tsing.tenant", value = "enable", matchIfMissing = true) // 允许使用 tsing.tenant.enable=false 禁用多租户
@EnableFeignClients(clients = TenantApi.class) // 主要是引入相关的 API 服务
public class TsingTenantRpcAutoConfiguration {

    @Bean
    public TenantRequestInterceptor tenantRequestInterceptor() {
        return new TenantRequestInterceptor();
    }

}

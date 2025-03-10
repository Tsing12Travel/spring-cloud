package cn.tsing.www.module.product.framework.rpc.config;

import cn.tsing.www.module.member.api.level.MemberLevelApi;
import cn.tsing.www.module.member.api.user.MemberUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {MemberUserApi.class, MemberLevelApi.class})
public class RpcConfiguration {
}

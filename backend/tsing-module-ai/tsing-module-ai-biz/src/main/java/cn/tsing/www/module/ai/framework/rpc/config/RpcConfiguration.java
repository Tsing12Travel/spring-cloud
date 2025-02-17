package cn.tsing.www.module.ai.framework.rpc.config;

import cn.tsing.www.module.infra.api.file.FileApi;
import cn.tsing.www.module.system.api.dict.DictDataApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {DictDataApi.class, FileApi.class})
public class RpcConfiguration {
}

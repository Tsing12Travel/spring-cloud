package cn.tsing.www.module.crm.framework.rpc.config;

import cn.tsing.www.module.bpm.api.task.BpmProcessInstanceApi;
import cn.tsing.www.module.system.api.dept.DeptApi;
import cn.tsing.www.module.system.api.dept.PostApi;
import cn.tsing.www.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {AdminUserApi.class, DeptApi.class, PostApi.class,
        BpmProcessInstanceApi.class})
public class RpcConfiguration {
}

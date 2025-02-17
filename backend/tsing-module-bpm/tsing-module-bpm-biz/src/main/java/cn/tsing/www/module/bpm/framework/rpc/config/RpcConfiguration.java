package cn.tsing.www.module.bpm.framework.rpc.config;

import cn.tsing.www.module.system.api.dept.DeptApi;
import cn.tsing.www.module.system.api.dept.PostApi;
import cn.tsing.www.module.system.api.dict.DictDataApi;
import cn.tsing.www.module.system.api.permission.RoleApi;
import cn.tsing.www.module.system.api.sms.SmsSendApi;
import cn.tsing.www.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {RoleApi.class, DeptApi.class, PostApi.class, AdminUserApi.class, SmsSendApi.class, DictDataApi.class})
public class RpcConfiguration {
}

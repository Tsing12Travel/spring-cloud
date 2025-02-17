package cn.tsing.www.module.infra.api.config;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.module.infra.dal.dataobject.config.ConfigDO;
import cn.tsing.www.module.infra.service.config.ConfigService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class ConfigApiImpl implements ConfigApi {

    @Resource
    private ConfigService configService;

    @Override
    public CommonResult<String> getConfigValueByKey(String key) {
        ConfigDO config = configService.getConfigByKey(key);
        return success(config != null ? config.getValue() : null);
    }

}

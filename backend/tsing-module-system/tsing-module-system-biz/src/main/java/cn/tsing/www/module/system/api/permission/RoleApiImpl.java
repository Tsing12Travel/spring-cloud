package cn.tsing.www.module.system.api.permission;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.module.system.service.permission.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.Collection;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class RoleApiImpl implements RoleApi {

    @Resource
    private RoleService roleService;

    @Override
    public CommonResult<Boolean> validRoleList(Collection<Long> ids) {
        roleService.validateRoleList(ids);
        return success(true);
    }
}

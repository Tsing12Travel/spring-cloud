package cn.tsing.www.module.member.api.level;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.module.member.api.level.dto.MemberLevelRespDTO;
import cn.tsing.www.module.member.convert.level.MemberLevelConvert;
import cn.tsing.www.module.member.enums.MemberExperienceBizTypeEnum;
import cn.tsing.www.module.member.service.level.MemberLevelService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import static cn.tsing.www.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.tsing.www.framework.common.pojo.CommonResult.success;
import static cn.tsing.www.module.member.enums.ErrorCodeConstants.EXPERIENCE_BIZ_NOT_SUPPORT;

/**
 * 会员等级 API 实现类
 *
 * @author owen
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class MemberLevelApiImpl implements MemberLevelApi {

    @Resource
    private MemberLevelService memberLevelService;

    @Override
    public CommonResult<MemberLevelRespDTO> getMemberLevel(Long id) {
        return success(MemberLevelConvert.INSTANCE.convert02(memberLevelService.getLevel(id)));
    }

    @Override
    public CommonResult<Boolean> addExperience(Long userId, Integer experience, Integer bizType, String bizId) {
        MemberExperienceBizTypeEnum bizTypeEnum = MemberExperienceBizTypeEnum.getByType(bizType);
        if (bizTypeEnum == null) {
            throw exception(EXPERIENCE_BIZ_NOT_SUPPORT);
        }
        memberLevelService.addExperience(userId, experience, bizTypeEnum, bizId);
        return success(true);
    }

    @Override
    public CommonResult<Boolean> reduceExperience(Long userId, Integer experience, Integer bizType, String bizId) {
        return addExperience(userId, -experience, bizType, bizId);
    }

}

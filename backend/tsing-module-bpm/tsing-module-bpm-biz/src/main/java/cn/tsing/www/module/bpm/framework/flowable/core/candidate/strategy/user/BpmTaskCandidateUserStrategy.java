package cn.tsing.www.module.bpm.framework.flowable.core.candidate.strategy.user;

import cn.hutool.core.text.StrPool;
import cn.tsing.www.framework.common.util.string.StrUtils;
import cn.tsing.www.module.bpm.framework.flowable.core.candidate.BpmTaskCandidateStrategy;
import cn.tsing.www.module.bpm.framework.flowable.core.enums.BpmTaskCandidateStrategyEnum;
import cn.tsing.www.module.system.api.user.AdminUserApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

/**
 * 用户 {@link BpmTaskCandidateStrategy} 实现类
 *
 * @author kyle
 */
@Component
public class BpmTaskCandidateUserStrategy implements BpmTaskCandidateStrategy {

    @Resource
    private AdminUserApi adminUserApi;

    @Override
    public BpmTaskCandidateStrategyEnum getStrategy() {
        return BpmTaskCandidateStrategyEnum.USER;
    }

    @Override
    public void validateParam(String param) {
        adminUserApi.validateUserList(StrUtils.splitToLongSet(param)).checkError();
    }

    @Override
    public LinkedHashSet<Long> calculateUsers(String param) {
        return new LinkedHashSet<>(StrUtils.splitToLong(param, StrPool.COMMA));
    }

}
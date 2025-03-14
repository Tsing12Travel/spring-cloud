package cn.tsing.www.module.promotion.job.combination;

import cn.hutool.core.util.StrUtil;
import cn.tsing.www.framework.common.core.KeyValue;
import cn.tsing.www.framework.tenant.core.job.TenantJob;
import cn.tsing.www.module.promotion.service.combination.CombinationRecordService;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

// TODO 芋艿：配置一个 Job
/**
 * 拼团过期 Job
 *
 * @author HUIHUI
 */
@Component
public class CombinationRecordExpireJob {

    @Resource
    private CombinationRecordService combinationRecordService;

    @XxlJob("combinationRecordExpireJob")
    @TenantJob // 多租户
    public String execute() {
        KeyValue<Integer, Integer> keyValue = combinationRecordService.expireCombinationRecord();
        return StrUtil.format("过期拼团 {} 个, 虚拟成团 {} 个", keyValue.getKey(), keyValue.getValue());
    }

}

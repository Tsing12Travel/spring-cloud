package cn.tsing.www.module.trade.job.brokerage;

import cn.hutool.core.util.StrUtil;
import cn.tsing.www.framework.tenant.core.job.TenantJob;
import cn.tsing.www.module.trade.service.brokerage.BrokerageRecordService;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * 佣金解冻 Job
 *
 * @author owen
 */
@Component
public class BrokerageRecordUnfreezeJob {

    @Resource
    private BrokerageRecordService brokerageRecordService;

    @XxlJob("brokerageRecordUnfreezeJob")
    @TenantJob // 多租户
    public String execute(String param) {
        int count = brokerageRecordService.unfreezeRecord();
        return StrUtil.format("解冻佣金 {} 个", count);
    }

}

package cn.tsing.www.module.trade.job.order;

import cn.tsing.www.framework.tenant.core.job.TenantJob;
import cn.tsing.www.module.trade.service.order.TradeOrderUpdateService;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * 交易订单的自动收货 Job
 *
 * @author 芋道源码
 */
@Component
public class TradeOrderAutoReceiveJob {

    @Resource
    private TradeOrderUpdateService tradeOrderUpdateService;

    @XxlJob("tradeOrderAutoReceiveJob")
    @TenantJob // 多租户
    public String execute() {
        int count = tradeOrderUpdateService.receiveOrderBySystem();
        return String.format("自动收货 %s 个", count);
    }

}

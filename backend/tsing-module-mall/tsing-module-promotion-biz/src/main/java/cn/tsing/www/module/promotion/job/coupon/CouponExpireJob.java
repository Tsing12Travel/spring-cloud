package cn.tsing.www.module.promotion.job.coupon;

import cn.hutool.core.util.StrUtil;
import cn.tsing.www.framework.tenant.core.job.TenantJob;
import cn.tsing.www.module.promotion.service.coupon.CouponService;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

// TODO 芋艿：配置一个 Job
/**
 * 优惠券过期 Job
 *
 * @author owen
 */
@Component
public class CouponExpireJob {

    @Resource
    private CouponService couponService;

    @XxlJob("couponExpireJob")
    @TenantJob // 多租户
    public String execute() {
        int count = couponService.expireCoupon();
        return StrUtil.format("过期优惠券 {} 个", count);
    }

}

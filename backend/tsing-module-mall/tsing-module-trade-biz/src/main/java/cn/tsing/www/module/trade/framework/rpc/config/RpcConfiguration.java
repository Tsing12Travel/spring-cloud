package cn.tsing.www.module.trade.framework.rpc.config;

import cn.tsing.www.module.member.api.address.MemberAddressApi;
import cn.tsing.www.module.member.api.config.MemberConfigApi;
import cn.tsing.www.module.member.api.level.MemberLevelApi;
import cn.tsing.www.module.member.api.point.MemberPointApi;
import cn.tsing.www.module.member.api.user.MemberUserApi;
import cn.tsing.www.module.pay.api.order.PayOrderApi;
import cn.tsing.www.module.pay.api.refund.PayRefundApi;
import cn.tsing.www.module.pay.api.transfer.PayTransferApi;
import cn.tsing.www.module.pay.api.wallet.PayWalletApi;
import cn.tsing.www.module.product.api.category.ProductCategoryApi;
import cn.tsing.www.module.product.api.comment.ProductCommentApi;
import cn.tsing.www.module.product.api.sku.ProductSkuApi;
import cn.tsing.www.module.product.api.spu.ProductSpuApi;
import cn.tsing.www.module.promotion.api.bargain.BargainActivityApi;
import cn.tsing.www.module.promotion.api.bargain.BargainRecordApi;
import cn.tsing.www.module.promotion.api.combination.CombinationRecordApi;
import cn.tsing.www.module.promotion.api.coupon.CouponApi;
import cn.tsing.www.module.promotion.api.discount.DiscountActivityApi;
import cn.tsing.www.module.promotion.api.point.PointActivityApi;
import cn.tsing.www.module.promotion.api.reward.RewardActivityApi;
import cn.tsing.www.module.promotion.api.seckill.SeckillActivityApi;
import cn.tsing.www.module.system.api.notify.NotifyMessageSendApi;
import cn.tsing.www.module.system.api.social.SocialClientApi;
import cn.tsing.www.module.system.api.social.SocialUserApi;
import cn.tsing.www.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {
        BargainActivityApi.class, BargainRecordApi.class, CombinationRecordApi.class,
        CouponApi.class, DiscountActivityApi.class, RewardActivityApi.class, SeckillActivityApi.class, PointActivityApi.class,
        MemberUserApi.class, MemberPointApi.class, MemberLevelApi.class, MemberAddressApi.class, MemberConfigApi.class,
        ProductSpuApi.class, ProductSkuApi.class, ProductCommentApi.class, ProductCategoryApi.class,
        PayOrderApi.class, PayRefundApi.class, PayTransferApi.class, PayWalletApi.class,
        AdminUserApi.class, NotifyMessageSendApi.class, SocialClientApi.class, SocialUserApi.class
})
public class RpcConfiguration {
}

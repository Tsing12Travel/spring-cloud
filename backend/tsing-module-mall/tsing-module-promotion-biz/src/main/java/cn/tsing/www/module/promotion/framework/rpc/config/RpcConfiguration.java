package cn.tsing.www.module.promotion.framework.rpc.config;

import cn.tsing.www.module.infra.api.websocket.WebSocketSenderApi;
import cn.tsing.www.module.member.api.user.MemberUserApi;
import cn.tsing.www.module.product.api.category.ProductCategoryApi;
import cn.tsing.www.module.product.api.sku.ProductSkuApi;
import cn.tsing.www.module.product.api.spu.ProductSpuApi;
import cn.tsing.www.module.system.api.social.SocialClientApi;
import cn.tsing.www.module.system.api.user.AdminUserApi;
import cn.tsing.www.module.trade.api.order.TradeOrderApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {ProductSkuApi.class, ProductSpuApi.class, ProductCategoryApi.class,
        MemberUserApi.class, TradeOrderApi.class, AdminUserApi.class, SocialClientApi.class,
        WebSocketSenderApi.class})
public class RpcConfiguration {
}

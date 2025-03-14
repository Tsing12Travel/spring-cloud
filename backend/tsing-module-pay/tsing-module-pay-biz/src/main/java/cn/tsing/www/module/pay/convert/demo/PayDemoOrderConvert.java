package cn.tsing.www.module.pay.convert.demo;

import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.module.pay.controller.admin.demo.vo.order.PayDemoOrderCreateReqVO;
import cn.tsing.www.module.pay.controller.admin.demo.vo.order.PayDemoOrderRespVO;
import cn.tsing.www.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}

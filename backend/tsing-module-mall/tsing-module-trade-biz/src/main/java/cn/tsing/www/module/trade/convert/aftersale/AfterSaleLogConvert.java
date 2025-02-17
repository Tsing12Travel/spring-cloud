package cn.tsing.www.module.trade.convert.aftersale;

import cn.tsing.www.module.trade.dal.dataobject.aftersale.AfterSaleLogDO;
import cn.tsing.www.module.trade.service.aftersale.bo.AfterSaleLogCreateReqBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AfterSaleLogConvert {

    AfterSaleLogConvert INSTANCE = Mappers.getMapper(AfterSaleLogConvert.class);

    AfterSaleLogDO convert(AfterSaleLogCreateReqBO bean);

}

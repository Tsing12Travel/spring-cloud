package cn.tsing.www.module.pay.convert.transfer;

import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.framework.pay.core.client.dto.transfer.PayTransferUnifiedReqDTO;
import cn.tsing.www.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import cn.tsing.www.module.pay.controller.admin.demo.vo.transfer.PayDemoTransferCreateReqVO;
import cn.tsing.www.module.pay.controller.admin.transfer.vo.PayTransferCreateReqVO;
import cn.tsing.www.module.pay.controller.admin.transfer.vo.PayTransferPageItemRespVO;
import cn.tsing.www.module.pay.controller.admin.transfer.vo.PayTransferRespVO;
import cn.tsing.www.module.pay.dal.dataobject.transfer.PayTransferDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayTransferConvert {

    PayTransferConvert INSTANCE = Mappers.getMapper(PayTransferConvert.class);

    PayTransferDO convert(PayTransferCreateReqDTO dto);

    PayTransferUnifiedReqDTO convert2(PayTransferDO dto);

    PayTransferCreateReqDTO convert(PayTransferCreateReqVO vo);

    PayTransferCreateReqDTO convert(PayDemoTransferCreateReqVO vo);

    PayTransferRespVO convert(PayTransferDO bean);

    PageResult<PayTransferPageItemRespVO> convertPage(PageResult<PayTransferDO> pageResult);

}

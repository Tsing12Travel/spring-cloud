package cn.tsing.www.module.pay.api.transfer;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.framework.common.util.object.BeanUtils;
import cn.tsing.www.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import cn.tsing.www.module.pay.api.transfer.dto.PayTransferRespDTO;
import cn.tsing.www.module.pay.dal.dataobject.transfer.PayTransferDO;
import cn.tsing.www.module.pay.service.transfer.PayTransferService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;

/**
 * 转账单 API 实现类
 *
 * @author jason
 */
@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class PayTransferApiImpl implements PayTransferApi {

    @Resource
    private PayTransferService payTransferService;

    @Override
    public CommonResult<Long> createTransfer(PayTransferCreateReqDTO reqDTO) {
        return success(payTransferService.createTransfer(reqDTO));
    }

    @Override
    public CommonResult<PayTransferRespDTO> getTransfer(Long id) {
        PayTransferDO transfer = payTransferService.getTransfer(id);
        return success(BeanUtils.toBean(transfer, PayTransferRespDTO.class));
    }

}

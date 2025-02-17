package cn.tsing.www.module.pay.convert.wallet;

import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.module.pay.controller.admin.wallet.vo.wallet.PayWalletRespVO;
import cn.tsing.www.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import cn.tsing.www.module.pay.dal.dataobject.wallet.PayWalletDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayWalletConvert {

    PayWalletConvert INSTANCE = Mappers.getMapper(PayWalletConvert.class);

    AppPayWalletRespVO convert(PayWalletDO bean);

    PayWalletRespVO convert02(PayWalletDO bean);

    PageResult<PayWalletRespVO> convertPage(PageResult<PayWalletDO> page);

}

package cn.tsing.www.module.system.api.mail;

import cn.tsing.www.framework.common.pojo.CommonResult;
import cn.tsing.www.module.system.api.mail.dto.MailSendSingleToUserReqDTO;
import cn.tsing.www.module.system.service.mail.MailSendService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

import static cn.tsing.www.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class MailSendApiImpl implements MailSendApi {

    @Resource
    private MailSendService mailSendService;

    @Override
    public CommonResult<Long> sendSingleMailToAdmin(MailSendSingleToUserReqDTO reqDTO) {
        return success(mailSendService.sendSingleMailToAdmin(reqDTO.getMail(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams()));
    }

    @Override
    public CommonResult<Long> sendSingleMailToMember(MailSendSingleToUserReqDTO reqDTO) {
        return success(mailSendService.sendSingleMailToMember(reqDTO.getMail(), reqDTO.getUserId(),
                reqDTO.getTemplateCode(), reqDTO.getTemplateParams()));
    }

}

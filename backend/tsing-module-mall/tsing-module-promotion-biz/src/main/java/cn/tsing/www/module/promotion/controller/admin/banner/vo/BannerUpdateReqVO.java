package cn.tsing.www.module.promotion.controller.admin.banner.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xia
 */
@Schema(description = "管理后台 - Banner更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BannerUpdateReqVO extends BannerBaseVO {

    @Schema(description = "banner 编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "banner 编号不能为空")
    private Long id;

}

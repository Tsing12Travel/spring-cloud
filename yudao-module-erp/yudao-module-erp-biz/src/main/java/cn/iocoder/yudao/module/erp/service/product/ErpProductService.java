package cn.iocoder.yudao.module.erp.service.product;

import jakarta.validation.Valid;

public interface ErpProductService {
    Long createProduct(@Valid ProductSaveReqVO )
}

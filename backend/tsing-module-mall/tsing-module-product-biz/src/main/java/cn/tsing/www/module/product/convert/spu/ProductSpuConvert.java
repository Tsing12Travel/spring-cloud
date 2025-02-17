package cn.tsing.www.module.product.convert.spu;

import cn.tsing.www.framework.common.util.collection.CollectionUtils;
import cn.tsing.www.framework.common.util.object.BeanUtils;
import cn.tsing.www.module.product.controller.admin.spu.vo.ProductSkuRespVO;
import cn.tsing.www.module.product.controller.admin.spu.vo.ProductSpuPageReqVO;
import cn.tsing.www.module.product.controller.admin.spu.vo.ProductSpuRespVO;
import cn.tsing.www.module.product.controller.app.spu.vo.AppProductSpuPageReqVO;
import cn.tsing.www.module.product.dal.dataobject.sku.ProductSkuDO;
import cn.tsing.www.module.product.dal.dataobject.spu.ProductSpuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static cn.tsing.www.framework.common.util.collection.CollectionUtils.convertMultiMap;

/**
 * 商品 SPU Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ProductSpuConvert {

    ProductSpuConvert INSTANCE = Mappers.getMapper(ProductSpuConvert.class);

    ProductSpuPageReqVO convert(AppProductSpuPageReqVO bean);

    default ProductSpuRespVO convert(ProductSpuDO spu, List<ProductSkuDO> skus) {
        ProductSpuRespVO spuVO = BeanUtils.toBean(spu, ProductSpuRespVO.class);
        spuVO.setSkus(BeanUtils.toBean(skus, ProductSkuRespVO.class));
        return spuVO;
    }

    default List<ProductSpuRespVO> convertForSpuDetailRespListVO(List<ProductSpuDO> spus, List<ProductSkuDO> skus) {
        Map<Long, List<ProductSkuDO>> skuMultiMap = convertMultiMap(skus, ProductSkuDO::getSpuId);
        return CollectionUtils.convertList(spus, spu -> convert(spu, skuMultiMap.get(spu.getId())));
    }

}

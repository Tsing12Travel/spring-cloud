package cn.tsing.www.module.product.dal.mysql.property;

import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tsing.www.module.product.controller.admin.property.vo.property.ProductPropertyPageReqVO;
import cn.tsing.www.module.product.dal.dataobject.property.ProductPropertyDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductPropertyMapper extends BaseMapperX<ProductPropertyDO> {

    default PageResult<ProductPropertyDO> selectPage(ProductPropertyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProductPropertyDO>()
                .likeIfPresent(ProductPropertyDO::getName, reqVO.getName())
                .betweenIfPresent(ProductPropertyDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProductPropertyDO::getId));
    }

    default ProductPropertyDO selectByName(String name) {
        return selectOne(ProductPropertyDO::getName, name);
    }

}

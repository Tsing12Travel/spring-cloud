package cn.tsing.www.module.erp.dal.mysql.stock;

import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.module.erp.dal.dataobject.stock.ErpStockCheckItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * ERP 库存盘点单项 Mapper
 */
@Mapper
public interface ErpStockCheckItemMapper extends BaseMapperX<ErpStockCheckItemDO> {
    default List<ErpStockCheckItemDO> selectListByCheckId(Long checkId) {
        return selectList(ErpStockCheckItemDO::getCheckId, checkId);
    }

    default List<ErpStockCheckItemDO> selectListByCheckIds(Collection<Long> checkIds) {
        return selectList(ErpStockCheckItemDO::getCheckId, checkIds);
    }

    default int deleteByCheckId(Long checkId) {
        return delete(ErpStockCheckItemDO::getCheckId, checkId);
    }
}
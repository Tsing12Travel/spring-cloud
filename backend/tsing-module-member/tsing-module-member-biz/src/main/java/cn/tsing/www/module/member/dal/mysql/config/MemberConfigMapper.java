package cn.tsing.www.module.member.dal.mysql.config;

import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.module.member.dal.dataobject.config.MemberConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 积分设置 Mapper
 *
 * @author QingX
 */
@Mapper
public interface MemberConfigMapper extends BaseMapperX<MemberConfigDO> {
}

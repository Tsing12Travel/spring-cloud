package cn.tsing.www.module.member.dal.mysql.group;

import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tsing.www.module.member.controller.admin.group.vo.MemberGroupPageReqVO;
import cn.tsing.www.module.member.dal.dataobject.group.MemberGroupDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户分组 Mapper
 *
 * @author owen
 */
@Mapper
public interface MemberGroupMapper extends BaseMapperX<MemberGroupDO> {

    default PageResult<MemberGroupDO> selectPage(MemberGroupPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberGroupDO>()
                .likeIfPresent(MemberGroupDO::getName, reqVO.getName())
                .eqIfPresent(MemberGroupDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MemberGroupDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MemberGroupDO::getId));
    }

    default List<MemberGroupDO> selectListByStatus(Integer status) {
        return selectList(MemberGroupDO::getStatus, status);
    }
}

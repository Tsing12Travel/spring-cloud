package cn.tsing.www.module.bpm.dal.mysql.oa;

import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.framework.mybatis.core.mapper.BaseMapperX;
import cn.tsing.www.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.tsing.www.module.bpm.controller.admin.oa.vo.BpmOALeavePageReqVO;
import cn.tsing.www.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 请假申请 Mapper
 *
 * @author jason
 * @author 芋道源码
 */
@Mapper
public interface BpmOALeaveMapper extends BaseMapperX<BpmOALeaveDO> {

    default PageResult<BpmOALeaveDO> selectPage(Long userId, BpmOALeavePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmOALeaveDO>()
                .eqIfPresent(BpmOALeaveDO::getUserId, userId)
                .eqIfPresent(BpmOALeaveDO::getStatus, reqVO.getStatus())
                .eqIfPresent(BpmOALeaveDO::getType, reqVO.getType())
                .likeIfPresent(BpmOALeaveDO::getReason, reqVO.getReason())
                .betweenIfPresent(BpmOALeaveDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmOALeaveDO::getId));
    }

}

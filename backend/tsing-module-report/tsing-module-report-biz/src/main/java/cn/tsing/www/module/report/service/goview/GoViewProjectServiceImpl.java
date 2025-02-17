package cn.tsing.www.module.report.service.goview;

import cn.tsing.www.framework.common.enums.CommonStatusEnum;
import cn.tsing.www.framework.common.pojo.PageParam;
import cn.tsing.www.framework.common.pojo.PageResult;
import cn.tsing.www.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import cn.tsing.www.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import cn.tsing.www.module.report.convert.goview.GoViewProjectConvert;
import cn.tsing.www.module.report.dal.dataobject.goview.GoViewProjectDO;
import cn.tsing.www.module.report.dal.mysql.goview.GoViewProjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.annotation.Resource;

import static cn.tsing.www.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.tsing.www.module.report.enums.ErrorCodeConstants.GO_VIEW_PROJECT_NOT_EXISTS;

/**
 * GoView 项目 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GoViewProjectServiceImpl implements GoViewProjectService {

    @Resource
    private GoViewProjectMapper goViewProjectMapper;

    @Override
    public Long createProject(GoViewProjectCreateReqVO createReqVO) {
        // 插入
        GoViewProjectDO goViewProject = GoViewProjectConvert.INSTANCE.convert(createReqVO)
                .setStatus(CommonStatusEnum.DISABLE.getStatus());
        goViewProjectMapper.insert(goViewProject);
        // 返回
        return goViewProject.getId();
    }

    @Override
    public void updateProject(GoViewProjectUpdateReqVO updateReqVO) {
        // 校验存在
        validateProjectExists(updateReqVO.getId());
        // 更新
        GoViewProjectDO updateObj = GoViewProjectConvert.INSTANCE.convert(updateReqVO);
        goViewProjectMapper.updateById(updateObj);
    }

    @Override
    public void deleteProject(Long id) {
        // 校验存在
        validateProjectExists(id);
        // 删除
        goViewProjectMapper.deleteById(id);
    }

    private void validateProjectExists(Long id) {
        if (goViewProjectMapper.selectById(id) == null) {
            throw exception(GO_VIEW_PROJECT_NOT_EXISTS);
        }
    }

    @Override
    public GoViewProjectDO getProject(Long id) {
        return goViewProjectMapper.selectById(id);
    }

    @Override
    public PageResult<GoViewProjectDO> getMyProjectPage(PageParam pageReqVO, Long userId) {
        return goViewProjectMapper.selectPage(pageReqVO, userId);
    }

}

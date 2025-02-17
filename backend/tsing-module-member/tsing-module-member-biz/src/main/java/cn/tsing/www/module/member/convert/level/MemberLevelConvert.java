package cn.tsing.www.module.member.convert.level;

import cn.tsing.www.module.member.api.level.dto.MemberLevelRespDTO;
import cn.tsing.www.module.member.controller.admin.level.vo.level.MemberLevelCreateReqVO;
import cn.tsing.www.module.member.controller.admin.level.vo.level.MemberLevelRespVO;
import cn.tsing.www.module.member.controller.admin.level.vo.level.MemberLevelSimpleRespVO;
import cn.tsing.www.module.member.controller.admin.level.vo.level.MemberLevelUpdateReqVO;
import cn.tsing.www.module.member.controller.app.level.vo.level.AppMemberLevelRespVO;
import cn.tsing.www.module.member.dal.dataobject.level.MemberLevelDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 会员等级 Convert
 *
 * @author owen
 */
@Mapper
public interface MemberLevelConvert {

    MemberLevelConvert INSTANCE = Mappers.getMapper(MemberLevelConvert.class);

    MemberLevelDO convert(MemberLevelCreateReqVO bean);

    MemberLevelDO convert(MemberLevelUpdateReqVO bean);

    MemberLevelRespVO convert(MemberLevelDO bean);

    List<MemberLevelRespVO> convertList(List<MemberLevelDO> list);

    List<MemberLevelSimpleRespVO> convertSimpleList(List<MemberLevelDO> list);

    List<AppMemberLevelRespVO> convertList02(List<MemberLevelDO> list);

    MemberLevelRespDTO convert02(MemberLevelDO bean);

}

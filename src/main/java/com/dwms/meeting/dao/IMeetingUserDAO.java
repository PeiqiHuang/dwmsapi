package com.dwms.meeting.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.meeting.model.bean.MeetingUser;
import com.dwms.meeting.model.vo.MeetUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会议人员DAO接口
 * @author windy
 * @date 2018-12-02
 */
public interface IMeetingUserDAO extends BaseMapper<MeetingUser> {

    /**
     * 会议人员列表
     * @author windy
     * @date 2018-12-03
     */
    List<MeetUserVO> selectSelective(@Param("mtgId") Integer mtgId);

    /**
     * 查询会议人员信息
     * @author windy
     * @date 2018-12-03
     */
    MeetingUser selectByMtgIdAndUserId(@Param("mtgId") Integer mtgId, @Param("userId") String userId);
}

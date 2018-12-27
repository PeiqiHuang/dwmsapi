package com.dwms.meeting.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.meeting.model.bean.MeetingSummaryUser;
import com.dwms.user.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会议纪要允许查看人员DAO
 * @author windy
 * @date 2018-12-03
 */
public interface IMeetingSummaryUserDAO extends BaseMapper<MeetingSummaryUser> {

    /**
     * 查询会议纪要人员
     * @author windy
     * @date 2018-12-05
     */
    List<UserVO> selectBySumId(@Param("status") Integer status, @Param("sumId") Integer sumId);

    /**
     * 更新状态
     * @author windy
     * @date 2018-12-05
     */
    int updateStatus(@Param("status") Integer status, @Param("sumId") Integer sumId, @Param("userId") String userId);

}

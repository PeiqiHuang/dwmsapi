package com.dwms.msg.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.meeting.model.bean.Meeting;
import com.dwms.msg.model.vo.MatterVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 最近事务DAO
 * @author windy
 * @date 2018-12-20
 */
public interface IMatterDAO extends BaseMapper<Meeting> {

    /**
     * 会议列表
     * @author windy
     * @date 2018-12-20
     */
    List<MatterVO> selectMeeting(@Param("userId") String userId);

    /**
     * 党费列表
     * @author windy
     * @date 2018-12-20
     */
    List<MatterVO> selectDue(@Param("userId") String userId);

    /**
     * 考试列表
     * @author windy
     * @date 2018-12-20
     */
    List<MatterVO> selectExamine(@Param("userId") String userId);

    /**
     * 学习列表
     * @author windy
     * @date 2018-12-20
     */
    List<MatterVO> selectCourse(@Param("userId") String userId);

}

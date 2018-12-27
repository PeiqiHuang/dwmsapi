package com.dwms.meeting.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.meeting.model.bean.Meeting;
import com.dwms.meeting.model.form.MyDetailForm;
import com.dwms.meeting.model.form.MyForm;
import com.dwms.meeting.model.vo.MeetDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会议信息DAO接口
 * @author windy
 * @date 2018-12-02
 */
public interface IMeetingDAO extends BaseMapper<Meeting> {

    /**
     * 我的会议
     * @author windy
     * @date 2018-12-03
     */
    List<Meeting> selectMy(@Param("form") MyForm form);


    MeetDetailVO selectMyDetail(@Param("form") MyDetailForm form);

}


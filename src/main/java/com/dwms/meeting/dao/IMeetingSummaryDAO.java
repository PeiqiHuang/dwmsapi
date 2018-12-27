package com.dwms.meeting.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.meeting.model.bean.MeetingSummary;
import com.dwms.meeting.model.vo.RecorderVO;
import com.dwms.meeting.model.vo.SummaryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会议纪要DAO接口
 * @author windy
 * @date 2018-12-02
 */
public interface IMeetingSummaryDAO extends BaseMapper<MeetingSummary> {

    /**
     * 查询会议纪要
     * @author windy
     * @date 2018-12-04
     */
    MeetingSummary selectByMtgId(@Param("mtgId") Integer mtgId, @Param("status") Integer status);

    /**
     * 查询会议纪要详情
     * @author windy
     * @date 2018-12-04
     */
    SummaryVO selectDetail(@Param("sumId") Integer sumId);

    /**
     * 相关纪要列表
     * @author windy
     * @date 2018-12-04
     */
    List<SummaryVO> selectRelation(@Param("userId") String userId);

    /**
     * 发布纪要列表
     * @author windy
     * @date 2018-12-04
     */
    List<SummaryVO> selectRelease(@Param("userId") String userId);

    /**
     * 对应会议列表
     * @author windy
     * @date 2018-12-04
     */
    List<RecorderVO> selectRecorder(@Param("userId") String userId);

    /**
     * 更新纪要状态
     * @author windy
     * @date 2018-12-04
     */
    int updateStatus(@Param("status") Integer status, @Param("mtgId") Integer mtgId);

}

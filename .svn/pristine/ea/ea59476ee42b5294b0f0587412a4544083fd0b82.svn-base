package com.dwms.notice.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.notice.model.bean.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通知公告DAO接口
 * @author windy
 * @date 2018-12-13
 */
public interface INoticeDAO extends BaseMapper<Notice> {

    /**
     * 通知公告列表
     * @author windy
     * @date 2018-12-13
     */
    List<Notice> selectByPartyId(@Param("partyId") Integer partyId);

}

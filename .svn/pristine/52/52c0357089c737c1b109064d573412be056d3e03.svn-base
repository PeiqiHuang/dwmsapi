package com.dwms.due.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.due.model.bean.Due;
import com.dwms.due.model.bean.DueUser;
import com.dwms.due.model.vo.DueVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 党费项目DAO接口
 * @author windy
 * @date 2018-12-17
 */
public interface IDueDAO extends BaseMapper<Due> {

    /**
     * 党费项目列表
     * @author windy
     * @date 2018-12-17
     */
    List<DueVO> selectByStatus(@Param("userId") String userId, @Param("status") Integer status);

    /**
     * 党费记录表
     * @author windy
     * @date 2018-12-17
     */
    DueUser selectByDueIdAndUserId(@Param("dueId") Integer dueId, @Param("userId") String userId);
}

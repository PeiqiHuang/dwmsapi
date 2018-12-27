package com.dwms.activity.dao;

import com.dwms.activity.model.bean.ActivityUser;
import com.dwms.activity.model.vo.ActCountVO;
import com.dwms.common.mapper.BaseMapper;
import com.dwms.user.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动人员DAO接口
 * @author windy
 * @date 2018-12-05
 */
public interface IActivityUserDAO extends BaseMapper<ActivityUser> {

    /**
     * 查询活动人员
     * @author windy
     * @date 2018-12-06
     */
    ActivityUser selectByActIdAndUserId(@Param("actId") Integer actId, @Param("userId") String userId, @Param("status") Integer status);

    /**
     * 查询活动人员
     * @author windy
     * @date 2018-12-06
     */
    List<UserVO> selectByActId(@Param("actId") Integer actId, @Param("status") Integer status);

    /**
     * 统计活动人数
     * @author windy
     * @date 2018-12-05
     */
    List<ActCountVO> countList(@Param("actIds") List<Integer> actIds);

    /**
     * 更新状态
     * @author windy
     * @date 2018-12-06
     */
    int updateStatus(@Param("auId") Integer auId, @Param("status") Integer status);
}


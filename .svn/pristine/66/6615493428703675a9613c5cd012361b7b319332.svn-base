package com.dwms.course.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.course.model.bean.CourseUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程人员DAO接口
 * @author windy
 * @date 2018-12-06
 */
public interface ICourseUserDAO extends BaseMapper<CourseUser> {

    /**
     * 课程人员
     * @author windy
     * @date 2018-12-07
     */
    CourseUser selectByCourseIdAndUserId(@Param("courseId") Integer courseId, @Param("userId") String userId);

    /**
     * 课程人员列表
     * @author windy
     * @date 2018-12-07
     */
    List<CourseUser> selectByUserIdAndCourseIds(@Param("userId") String userId, @Param("courseIds") List<Integer> courseIds);

}

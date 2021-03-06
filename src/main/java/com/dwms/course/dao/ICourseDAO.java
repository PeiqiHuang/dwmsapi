package com.dwms.course.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.course.model.bean.Course;
import com.dwms.course.model.form.ListForm;
import com.dwms.course.model.form.MyForm;
import com.dwms.course.model.vo.CourseVO;
import com.dwms.course.model.vo.DetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微课程DAO接口
 * @author windy
 * @date 2018-12-06
 */
public interface ICourseDAO extends BaseMapper<Course> {

    /**
     * 课程详情
     * @author windy
     * @date 2018-12-07
     */
    DetailVO selectDetail(@Param("courseId") Integer courseId, @Param("userId") String userId);

    /**
     * 课程列表
     * @author windy
     * @date 2018-12-06
     */
    List<CourseVO> selectSelective(@Param("form") ListForm form);

    /**
     * 我的课程
     * @author windy
     * @date 2018-12-07
     */
    List<CourseVO> selectMy(@Param("form") MyForm from);

}

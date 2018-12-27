package com.dwms.course.service;

import com.dwms.common.model.ResultBean;
import com.dwms.course.model.form.*;
import com.dwms.course.model.vo.CourseVO;
import com.github.pagehelper.Page;

/**
 * 课程服务
 * @author windy
 * @date 2018-12-07
 */
public interface ICourseService {

    /**
     * 课程详情
     * @author windy
     * @date 2018-12-10
     */
    ResultBean getDetail(DetailForm form);

    /**
     * 课程列表
     * @author windy
     * @date 2018-12-07
     */
    ResultBean getList(Page<CourseVO> page, ListForm form);

    /**
     * 我的课程
     * @author windy
     * @date 2018-12-07
     */
    ResultBean getMy(Page<CourseVO> page, MyForm form);

    /**
     * 加入学习
     * @author windy
     * @date 2018-12-07
     */
    ResultBean saveLearn(LearnForm form);

    /**
     * 更新进度
     * @author windy
     * @date 2018-12-10
     */
    ResultBean updateProgress(SyncForm form);
}

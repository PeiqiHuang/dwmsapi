package com.dwms.course.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.course.model.form.*;
import com.dwms.course.model.vo.CourseVO;
import com.dwms.course.service.ICourseService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 课程Controller
 * @author windy
 * @date 2018-12-07
 */
@RequestMapping("/course/")
@Controller
public class CourseController {

    @Resource
    private ICourseService courseService;

    /**
     * 课程详情
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ResultBean detail(@Valid DetailForm form) {
        return courseService.getDetail(form);
    }

    /**
     * 课程列表
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(Page<CourseVO> page, @Valid ListForm form) {
        return courseService.getList(page, form);
    }

    /**
     * 我的课程
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "my.do")
    @ResponseBody
    public ResultBean my(Page<CourseVO> page, @Valid MyForm form) {
        return courseService.getMy(page, form);
    }

    /**
     * 加入学习
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "learn.do")
    @ResponseBody
    public ResultBean learn(@Valid LearnForm form) {
        return courseService.saveLearn(form);
    }

    /**
     * 更新进度
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "progress.do")
    @ResponseBody
    public ResultBean progress(@Valid SyncForm form) {
        return courseService.updateProgress(form);
    }
}

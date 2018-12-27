package com.dwms.activity.controller;

import com.dwms.activity.model.form.ApplyForm;
import com.dwms.activity.model.form.DetailForm;
import com.dwms.activity.model.form.ListForm;
import com.dwms.activity.model.vo.ActivityVO;
import com.dwms.activity.service.IActivityService;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 活动Controller
 * @author windy
 * @date 2018-12-06
 */
@Controller
@RequestMapping("/act/")
public class ActivityController {

    @Resource
    private IActivityService activityService;

    /**
     * 活动详情
     * @author windy
     * @date 2018-12-06
     */
    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ResultBean detail(@Valid DetailForm form) {
        return activityService.getDetail(form);
    }

    /**
     * 活动列表
     * @author windy
     * @date 2018-12-06
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(Page<ActivityVO> page, @Valid ListForm form) {
        return activityService.getList(page, form);
    }

    /**
     * 报名
     * @author windy
     * @date 2018-12-06
     */
    @RequestMapping(value = "apply.do")
    @ResponseBody
    public ResultBean apply(@Valid ApplyForm form) {
        return activityService.updApply(form);
    }
}

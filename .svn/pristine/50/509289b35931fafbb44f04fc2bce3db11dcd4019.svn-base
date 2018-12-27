package com.dwms.meeting.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.meeting.model.bean.Meeting;
import com.dwms.meeting.model.form.*;
import com.dwms.meeting.service.IMeetingService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 会议Controller
 * @author windy
 * @date 2018-12-04
 */
@RequestMapping("/meeting/")
@Controller
public class MeetingController {

    @Resource
    private IMeetingService meetingService;

    /**
     * 我的会议列表
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "my.do")
    @ResponseBody
    public ResultBean my(Page<Meeting> page, @Valid MyForm form) {
        return meetingService.my(page, form);
    }

    /**
     * 我的会议详情
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "myDetail.do")
    @ResponseBody
    public ResultBean myDetail(@Valid MyDetailForm form) {
        return meetingService.myDetail(form);
    }

    /**
     * 报名
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "apply.do")
    @ResponseBody
    public ResultBean apply(@Valid ApplyForm form) {
        return meetingService.updApply(form);
    }

    /**
     * 请假
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "off.do")
    @ResponseBody
    public ResultBean off(@Valid OffForm form) {
        return meetingService.updOff(form);
    }

    /**
     * 签到
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "signIn.do")
    @ResponseBody
    public ResultBean signIn(@Valid SignInForm form) {
        return meetingService.updSignIn(form);
    }
}

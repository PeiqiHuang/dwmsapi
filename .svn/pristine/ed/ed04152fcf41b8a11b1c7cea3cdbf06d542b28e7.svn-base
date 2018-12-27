package com.dwms.meeting.service;

import com.dwms.common.model.ResultBean;
import com.dwms.meeting.model.bean.Meeting;
import com.dwms.meeting.model.form.*;
import com.github.pagehelper.Page;

/**
 * 会议服务
 * @author windy
 * @date 2018-12-04
 */
public interface IMeetingService {

    /**
     * 我的会议列表
     * @author windy
     * @date 2018-12-04
     */
    ResultBean my(Page<Meeting> page, MyForm form);

    /**
     * 我的会议详情
     * @author windy
     * @date 2018-12-04
     */
    ResultBean myDetail(MyDetailForm form);

    /**
     * 报名
     * @author windy
     * @date 2018-12-04
     */
    ResultBean updApply(ApplyForm form);

    /**
     * 请假
     * @author windy
     * @date 2018-12-04
     */
    ResultBean updOff(OffForm form);

    /**
     * 签到
     * @author windy
     * @date 2018-12-04
     */
    ResultBean updSignIn(SignInForm form);
}

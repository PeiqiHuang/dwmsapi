package com.dwms.msg.controller;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.model.ResultBean;
import com.dwms.msg.service.IMatterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 最近事务controller
 * @author windy
 * @date 2018-12-20
 */
@Controller
@RequestMapping("/msg/matter/")
public class MatterController {


    @Resource
    private IMatterService matterService;

    /**
     * 待办事务
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "recent.do")
    @ResponseBody
    public ResultBean recent(@Valid UserIdForm form) {
        return matterService.recent(form);

    }

    /**
     * 最近事务列表
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(@Valid UserIdForm form) {
        return matterService.list(form);

    }
}

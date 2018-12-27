package com.dwms.due.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.due.model.form.ConfirmForm;
import com.dwms.due.model.form.DetailForm;
import com.dwms.due.model.form.ListForm;
import com.dwms.due.model.vo.DueVO;
import com.dwms.due.service.IDueService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 党费Controller
 * @author windy
 * @date 2018-12-17
 */
@Controller
@RequestMapping("/due/")
public class DueController {

    @Resource
    private IDueService dueService;

    /**
     * 党费详情
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ResultBean detail(@Valid DetailForm form) {
        return dueService.detail(form);
    }

    /**
     * 党费列表
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(Page<DueVO> page, @Valid ListForm form) {
        return dueService.list(page, form);
    }

    /**
     * 确认缴费
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "confirm.do")
    @ResponseBody
    public ResultBean confirm(@Valid ConfirmForm form) {
        return dueService.updConfirm(form);
    }

}

package com.dwms.help.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.help.model.form.DetailForm;
import com.dwms.help.model.form.ListForm;
import com.dwms.help.service.IHelpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 10:24
 * @Description: 帮助中心Controller
 */
@Controller
@RequestMapping("/help/")
public class HelpController {

    @Resource
    private IHelpService helpService;

    /**
     * 帮助信息列表
     * @author yunbin
     * @date 2018-12-17
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(@Valid ListForm form) {
        return helpService.getList(form);
    }

    /**
     * 帮助信息详情
     * @author yunbin
     * @date 2018-12-17
     */
    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ResultBean detail(@Valid DetailForm form) {
        return helpService.getDetail(form);
    }
}

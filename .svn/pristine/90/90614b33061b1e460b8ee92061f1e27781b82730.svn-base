package com.dwms.advice.controller;

import com.dwms.advice.model.form.AddForm;
import com.dwms.advice.service.IAdviceService;
import com.dwms.common.model.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Auther: yunbin
 * @Date: 2018/12/18 15:09
 * @Description: 反馈建议控制类
 */
@Controller
@RequestMapping("/advice/")
public class AdviceController {
    @Resource
    private IAdviceService adviceService;

    /**
     * 添加反馈
     * @author yunbin
     * @date 2018-12-18
     */
    @RequestMapping(value = "add.do")
    @ResponseBody
    public ResultBean wish(@Valid AddForm form) {
        return adviceService.addAdvice(form);
    }
}

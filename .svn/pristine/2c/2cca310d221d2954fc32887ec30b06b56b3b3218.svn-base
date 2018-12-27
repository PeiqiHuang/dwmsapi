package com.dwms.examine.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.examine.model.form.AnswerForm;
import com.dwms.examine.model.form.ListForm;
import com.dwms.examine.model.form.SaveAnswerForm;
import com.dwms.examine.model.vo.ExamineVO;
import com.dwms.examine.service.IExamineService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 考试Controller
 * @author windy
 * @date 2018-12-17
 */
@Controller
@RequestMapping("/examine/")
public class ExamineController {

    @Resource
    private IExamineService examineService;

    /**
     * 考试详情
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ResultBean detail(@RequestParam Integer euId) {
        return examineService.getDetail(euId);
    }

    /**
     * 考试列表
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(Page<ExamineVO> page, @Valid ListForm form) {
        return examineService.list(page, form);
    }

    /**
     * 考试答案
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "answer.do")
    @ResponseBody
    public ResultBean answer(@Valid AnswerForm form) {
        return examineService.getAnswer(form);
    }

    /**
     * 答题
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "save.do")
    @ResponseBody
    public ResultBean save(@Valid SaveAnswerForm form) {
        return examineService.saveAnswer(form);
    }
}

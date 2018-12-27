package com.dwms.news.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.news.model.bean.NewsBuild;
import com.dwms.news.model.form.ListForm;
import com.dwms.news.service.INewsBuildService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 党建要闻Controller
 * @author windy
 * @date 2018-12-12
 */
@Controller
@RequestMapping("/news/build")
public class NewsBuildController {

    @Resource
    private INewsBuildService newsBuildService;

    /**
     * 首页党建要闻
     * @author windy
     * @date 2018-12-12
     */
    @RequestMapping("/index.do")
    @ResponseBody
    public ResultBean index() {
        return newsBuildService.index();
    }

    /**
     * 要闻列表
     * @author windy
     * @date 2018-12-12
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ResultBean list(Page<NewsBuild> page, @Valid ListForm form) {
        return newsBuildService.list(page, form);
    }
}

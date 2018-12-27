package com.dwms.crawler.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.crawler.service.ICrawlerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 共产党员网Controller
 * @author windy
 * @date 2018-12-11
 */
@Controller
@RequestMapping("/crawler/gongchang/")
public class GongChangController {

    @Resource
    private ICrawlerService crawlerService;

    /**
     * 开始爬虫
     * @author windy
     * @date 2018-12-12
     */
    @RequestMapping(value = "/begin.do")
    @ResponseBody
    public ResultBean begin() {
        return crawlerService.gongChang();
    }

}

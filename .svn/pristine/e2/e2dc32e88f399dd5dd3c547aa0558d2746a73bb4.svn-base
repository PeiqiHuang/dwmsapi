package com.dwms.notice.controller;

import com.dwms.base.model.form.PartyIdForm;
import com.dwms.common.model.ResultBean;
import com.dwms.notice.model.bean.Notice;
import com.dwms.notice.service.INoticeService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 通知公告Controller
 * @author windy
 * @date 2018-12-12
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private INoticeService noticeService;

    /**
     * 首页通知公告
     * @author windy
     * @date 2018-12-12
     */
    @RequestMapping("/index.do")
    @ResponseBody
    public ResultBean index(@Valid PartyIdForm form) {
        return noticeService.index(form);
    }

    /**
     * 公告列表
     * @author windy
     * @date 2018-12-12
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ResultBean list(Page<Notice> page, @Valid PartyIdForm form) {
        return noticeService.list(page, form);
    }

}

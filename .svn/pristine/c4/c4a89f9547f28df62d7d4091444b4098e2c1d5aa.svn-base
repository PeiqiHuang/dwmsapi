package com.dwms.meeting.controller;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.model.ResultBean;
import com.dwms.meeting.model.form.DelSummaryForm;
import com.dwms.meeting.model.form.ReadForm;
import com.dwms.meeting.model.form.SaveSummaryForm;
import com.dwms.meeting.model.form.UpdSummaryForm;
import com.dwms.meeting.model.vo.SummaryVO;
import com.dwms.meeting.service.ISummaryService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 会议纪要Controller
 * @author windy
 * @date 2018-12-04
 */
@Controller
@RequestMapping("/meeting/summary")
public class SummaryController {

    @Resource
    private ISummaryService summaryService;

    /**
     * 纪要详情
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "detail.do")
    @ResponseBody
    public ResultBean detail(@RequestParam Integer sumId) {
        return summaryService.getDetail(sumId);
    }

    /**
     * 相关纪要列表
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "relation.do")
    @ResponseBody
    public ResultBean relation(Page<SummaryVO> page, @Valid UserIdForm form) {
        return summaryService.getRelation(page, form);
    }

    /**
     * 发布纪要列表
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "release.do")
    @ResponseBody
    public ResultBean release(Page<SummaryVO> page, @Valid UserIdForm form) {
        return summaryService.getRelease(page, form);
    }

    /**
     * 对应会议列表
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "recorder.do")
    @ResponseBody
    public ResultBean recorder(@Valid UserIdForm form) {
        return summaryService.getRecorder(form);
    }

    /**
     * 保存纪要
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "save.do")
    @ResponseBody
    public ResultBean save(@Valid SaveSummaryForm form) {
        return summaryService.save(form);
    }

    /**
     * 修改纪要
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "upd.do")
    @ResponseBody
    public ResultBean upd(@Valid UpdSummaryForm form) {
        return summaryService.upd(form);
    }

    /**
     * 删除纪要
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "del.do")
    @ResponseBody
    public ResultBean del(@Valid DelSummaryForm form) {
        return summaryService.del(form);
    }

    /**
     * 已读纪要
     * @author windy
     * @date 2018-12-04
     */
    @RequestMapping(value = "read.do")
    @ResponseBody
    public ResultBean read(@Valid ReadForm form) {
        return summaryService.updRead(form);
    }
}

package com.dwms.meeting.service.impl;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.config.ImageConfig;
import com.dwms.common.config.SysConfig;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.FileUtils;
import com.dwms.common.util.HtmlContentUtils;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.HtmlUtils;
import com.dwms.meeting.consts.MeetingConsts;
import com.dwms.meeting.dao.IMeetingDAO;
import com.dwms.meeting.dao.IMeetingSummaryDAO;
import com.dwms.meeting.dao.IMeetingSummaryUserDAO;
import com.dwms.meeting.dao.IMeetingUserDAO;
import com.dwms.meeting.model.bean.Meeting;
import com.dwms.meeting.model.bean.MeetingSummary;
import com.dwms.meeting.model.form.DelSummaryForm;
import com.dwms.meeting.model.form.ReadForm;
import com.dwms.meeting.model.form.SaveSummaryForm;
import com.dwms.meeting.model.form.UpdSummaryForm;
import com.dwms.meeting.model.vo.RecorderVO;
import com.dwms.meeting.model.vo.SummaryVO;
import com.dwms.meeting.service.ISummaryService;
import com.dwms.user.consts.UserConsts;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.vo.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 会议纪要服务
 * @author windy
 * @date 2018-12-04
 */
@Service
public class SummaryService implements ISummaryService {

    @Resource
    private IMeetingDAO meetingDAO;
    @Resource
    private IMeetingUserDAO meetingUserDAO;
    @Resource
    private IUserDAO userDAO;
    @Resource
    private IMeetingSummaryDAO meetingSummaryDAO;
    @Resource
    private IMeetingSummaryUserDAO meetingSummaryUserDAO;
    @Resource
    private SysConfig sysConfig;
    @Resource
    private ImageConfig imageConfig;

    @Override
    public ResultBean getDetail(Integer sumId) {
        SummaryVO s = meetingSummaryDAO.selectDetail(sumId);
        if (s == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议纪要不存在");
        }

        List<UserVO> us = meetingSummaryUserDAO.selectBySumId(MeetingConsts.SUMMARY_USER_STATUS_READ, sumId);

        s = HtmlUtils.summary(s);
        s.setContent(HtmlContentUtils.text(s.getFilePath()));

        Map<String, Object> data = Maps.newHashMap();
        data.put("summary", s);
        data.put("reads", us);
        return ResultUtils.successBean(data);
    }


    @Override
    public ResultBean getRelation(Page<SummaryVO> page, UserIdForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getStatus() == UserConsts.STATUS_CLOSE) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> meetingSummaryDAO.selectRelation(form.getUserId()));
        HtmlUtils.summary(page.getResult());
        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean getRelease(Page<SummaryVO> page, UserIdForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getStatus() == UserConsts.STATUS_CLOSE) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> meetingSummaryDAO.selectRelease(form.getUserId()));
        HtmlUtils.summary(page.getResult());
        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean getRecorder(UserIdForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getStatus() == UserConsts.STATUS_CLOSE) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        List<RecorderVO> ms = meetingSummaryDAO.selectRecorder(form.getUserId());
        return ResultUtils.successBean(ms);
    }

    @Override
    public ResultBean save(SaveSummaryForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getStatus() == UserConsts.STATUS_CLOSE) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        Meeting m = meetingDAO.selectByPrimaryKey(form.getMtgId());
        if (m == null || MeetingConsts.INFO_STATUS_RELEASE != m.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        } else if (m.getEndTime().getTime() > System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议未结束，不允许保存纪要");
        }

        if (!form.getUserId().equals(m.getRecorder())) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "不允许用户编辑该会议纪要");
        }

        MeetingSummary s = meetingSummaryDAO.selectByMtgId(form.getMtgId(), MeetingConsts.SUMMARY_STATUS_RELEASE);
        if (s != null) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "会议已发布纪要");
        }

        //保存会议纪要
        MeetingSummary ms = new MeetingSummary();
        ms.setMtgId(form.getMtgId());
        ms.setSumTitle(form.getSumTitle());
        ms.setOperator(form.getUserId());
        ms.setSource(MeetingConsts.SUMMARY_SOURCE_APP);
        ms.setStatus(form.getStatus());
        if (form.getStatus() == MeetingConsts.SUMMARY_STATUS_RELEASE) {
            ms.setReleaseTime(new Date());
        }
        if (meetingSummaryDAO.insertSelective(ms) < 1) {
            switch (form.getStatus()) {
                case MeetingConsts.SUMMARY_STATUS_RELEASE:
                    return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "发布会议纪要失败");
                case MeetingConsts.SUMMARY_STATUS_WAITING:
                    return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "保存会议纪要草稿失败");
                default:
                    return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "保存会议纪要失败");
            }
        }

        //保存文件
        String fileName = System.currentTimeMillis() + ".html";
        String filePath = sysConfig.getHtmlRoot() + imageConfig.getMtgSummary() + "/" + ms.getSumId() + "/" + fileName;
        ms.setFilePath(filePath);
        String basePath = sysConfig.getUploadPath() + sysConfig.getHtmlRoot() + imageConfig.getMtgSummary() + "/" + ms.getSumId() + "/";
        String content = HtmlContentUtils.html(form.getContent());
        boolean ok = FileUtils.save(content, basePath, fileName);
        if (!ok) {
            throw new RuntimeException("保存文件失败");
        }
        MeetingSummary mf = new MeetingSummary();
        mf.setSumId(ms.getSumId());
        mf.setFilePath(filePath);
        meetingSummaryDAO.updateByPrimaryKeySelective(mf);

        return ResultUtils.successBean();
    }

    @Override
    public ResultBean upd(UpdSummaryForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getStatus() == UserConsts.STATUS_CLOSE) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        MeetingSummary s = meetingSummaryDAO.selectByPrimaryKey(form.getSumId());
        if (s == null) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "会议纪要不存在");
        }

        Meeting m = meetingDAO.selectByPrimaryKey(s.getMtgId());
        if (m == null || MeetingConsts.INFO_STATUS_RELEASE != m.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        } else if (m.getEndTime().getTime() > System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议未结束，不允许修改纪要");
        }

        if (!form.getUserId().equals(m.getRecorder())) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "不允许用户修改该会议纪要");
        }

        //修改会议纪要
        String fileName = System.currentTimeMillis() + ".html";
        String filePath = sysConfig.getHtmlRoot() + imageConfig.getMtgSummary() + "/" + s.getSumId() + "/" + fileName;
        s.setFilePath(filePath);
        s.setSumTitle(form.getSumTitle());
        s.setOperator(form.getUserId());
        s.setSource(MeetingConsts.SUMMARY_SOURCE_APP);
        s.setStatus(form.getStatus());
        if (form.getStatus() == MeetingConsts.SUMMARY_STATUS_RELEASE) {
            s.setReleaseTime(new Date());
        }
        meetingSummaryDAO.updateStatus(MeetingConsts.SUMMARY_STATUS_WAITING, s.getMtgId());
        meetingSummaryDAO.updateByPrimaryKeySelective(s);

        //保存文件
        String basePath = sysConfig.getUploadPath() + sysConfig.getHtmlRoot() + imageConfig.getMtgSummary() + "/" + s.getSumId() + "/";
        boolean ok = FileUtils.save(form.getContent(), basePath, fileName);
        if (!ok) {
            throw new RuntimeException("修改文件失败");
        }

        return ResultUtils.successBean();
    }

    @Override
    public ResultBean del(DelSummaryForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getStatus() == UserConsts.STATUS_CLOSE) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        MeetingSummary s = meetingSummaryDAO.selectByPrimaryKey(form.getSumId());
        if (s == null) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "会议纪要不存在");
        }

        Meeting m = meetingDAO.selectByPrimaryKey(s.getMtgId());
        if (m == null || MeetingConsts.INFO_STATUS_RELEASE != m.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        } else if (m.getEndTime().getTime() > System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议未结束，不允许修改纪要");
        }

        if (!form.getUserId().equals(m.getRecorder())) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "不允许用户删除该会议纪要");
        }

        //修改会议纪要
        MeetingSummary ms = new MeetingSummary();
        ms.setSumId(form.getSumId());
        ms.setOperator(form.getUserId());
        ms.setSource(MeetingConsts.SUMMARY_SOURCE_APP);
        ms.setStatus(MeetingConsts.SUMMARY_STATUS_CLOSE);
        meetingSummaryDAO.updateByPrimaryKeySelective(ms);
        return ResultUtils.successBean();
    }

    @Override
    public ResultBean updRead(ReadForm form) {
        meetingSummaryUserDAO.updateStatus(MeetingConsts.SUMMARY_USER_STATUS_READ, form.getSumId(), form.getUserId());
        return ResultUtils.successBean();
    }
}

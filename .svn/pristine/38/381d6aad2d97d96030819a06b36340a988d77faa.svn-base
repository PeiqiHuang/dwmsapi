package com.dwms.notice.service.impl;

import com.dwms.base.model.form.PartyIdForm;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.HtmlContentUtils;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.HtmlUtils;
import com.dwms.notice.dao.INoticeDAO;
import com.dwms.notice.model.bean.Notice;
import com.dwms.notice.service.INoticeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通知公告服务
 * @author windy
 * @date 2018-12-13
 */
@Service
public class NoticeService implements INoticeService {

    @Resource
    private INoticeDAO noticeDAO;

    @Override
    public ResultBean index(PartyIdForm form) {
        List<Notice> notices = PageHelper.startPage(0, 3, false).doSelectPage(() -> noticeDAO.selectByPartyId(form.getPartyId()));
        notices = HtmlUtils.notice(notices);
        return ResultUtils.successBean(notices);
    }

    @Override
    public ResultBean list(Page<Notice> page, PartyIdForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> noticeDAO.selectByPartyId(form.getPartyId()));
        HtmlUtils.notice(page.getResult());
        return ResultUtils.successBean(PageUtils.map(page));
    }
}
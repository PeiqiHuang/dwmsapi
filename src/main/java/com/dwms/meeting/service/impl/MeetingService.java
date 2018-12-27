package com.dwms.meeting.service.impl;

import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.meeting.consts.MeetingConsts;
import com.dwms.meeting.dao.IMeetingDAO;
import com.dwms.meeting.dao.IMeetingUserDAO;
import com.dwms.meeting.model.bean.Meeting;
import com.dwms.meeting.model.bean.MeetingUser;
import com.dwms.meeting.model.form.*;
import com.dwms.meeting.model.vo.MeetDetailVO;
import com.dwms.meeting.model.vo.MeetUserVO;
import com.dwms.meeting.service.IMeetingService;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.vo.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 会议服务实现类
 * @author windy
 * @date 2018-12-03
 */
@Service
public class MeetingService implements IMeetingService {

    @Resource
    private IMeetingDAO meetingDAO;
    @Resource
    private IMeetingUserDAO meetingUserDAO;
    @Resource
    private IUserDAO userDAO;

    @Override
    public ResultBean my(Page<Meeting> page, MyForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getPartyId() == null) {
            return ResultUtils.successBean();
        }

        form.setPartyId(u.getPartyId());
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> meetingDAO.selectMy(form));

        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean myDetail(MyDetailForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        }

        MeetDetailVO m = meetingDAO.selectMyDetail(form);
        if (m == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        }

        //参会人信息
        List<MeetUserVO> signins = Lists.newArrayList();//已签到人信息
        List<MeetUserVO> confirms = Lists.newArrayList();//参加人信息
        List<MeetUserVO> waitings = Lists.newArrayList();//待定人信息
        List<MeetUserVO> offs = Lists.newArrayList();//请假人信息

        List<MeetUserVO> mus = meetingUserDAO.selectSelective(m.getMtgId());
        if (CollectionUtils.isNotEmpty(mus)) {
            for (MeetUserVO mu : mus) {
                switch (mu.getStatus()) {
                    case MeetingConsts.USER_OFF:
                        offs.add(mu);
                        break;
                    case MeetingConsts.USER_WAITING:
                        waitings.add(mu);
                        break;
                    case MeetingConsts.USER_CONFIRM:
                        confirms.add(mu);
                        break;
                    case MeetingConsts.USER_SIGNIN:
                        signins.add(mu);
                        break;
                    default:
                        break;
                }
            }
        }

        //返回数据
        Map<String, Object> data = Maps.newHashMap();
        data.put("meeting", m);
        data.put("offs", offs);
        data.put("waitings", waitings);
        data.put("confirms", confirms);
        data.put("signins", signins);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean updApply(ApplyForm form) {
        Meeting m = meetingDAO.selectByPrimaryKey(form.getMtgId());
        if (m == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        } else if (m.getEndTime().getTime() < System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "会议已结束");
        }


        MeetingUser mu = meetingUserDAO.selectByMtgIdAndUserId(form.getMtgId(), form.getUserId());
        if (mu == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议记录不存在");
        }

        if (mu.getStatus() == MeetingConsts.USER_OFF) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户已请假，不允许再报名");
        } else if (mu.getStatus() == MeetingConsts.USER_CONFIRM) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户已报名");
        } else if (mu.getStatus() == MeetingConsts.USER_SIGNIN) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户已签到，不需报名");
        }

        MeetingUser rm = new MeetingUser();
        rm.setMuId(mu.getMuId());
        rm.setStatus(MeetingConsts.USER_CONFIRM);
        int i = meetingUserDAO.updateByPrimaryKeySelective(rm);
        if (i < 1) {
            return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "报名失败");
        }

        return ResultUtils.successBean();
    }

    @Override
    public ResultBean updOff(OffForm form) {
        Meeting m = meetingDAO.selectByPrimaryKey(form.getMtgId());
        if (m == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        } else if (m.getEndTime().getTime() < System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "会议已结束");
        }

        MeetingUser mu = meetingUserDAO.selectByMtgIdAndUserId(form.getMtgId(), form.getUserId());
        if (mu == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议记录不存在");
        }

        if (mu.getStatus() == MeetingConsts.USER_OFF) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户已请假");
        } else if (mu.getStatus() == MeetingConsts.USER_SIGNIN) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户已签到，不允许请假");
        }

        MeetingUser rm = new MeetingUser();
        rm.setMuId(mu.getMuId());
        rm.setOffReason(form.getOffReason());
        rm.setStatus(MeetingConsts.USER_OFF);
        int i = meetingUserDAO.updateByPrimaryKeySelective(rm);
        if (i < 1) {
            return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "请假失败");
        }

        return ResultUtils.successBean();
    }

    @Override
    public ResultBean updSignIn(SignInForm form) {
        Meeting m = meetingDAO.selectByPrimaryKey(form.getMtgId());
        if (m == null || m.getStatus() != MeetingConsts.INFO_STATUS_RELEASE) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不存在");
        } else if (m.getSignHelp() == MeetingConsts.INFO_SIGNHELP_NO && form.getSignWay() == MeetingConsts.USER_SIGNWAY_INSTEAD) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "会议不允许代签");
        } else if (m.getStatus() == MeetingConsts.USER_SIGNIN) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "用户已签到");
        } else if (m.getEndTime().getTime() < System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "会议已结束");
        }

        MeetingUser mu = meetingUserDAO.selectByMtgIdAndUserId(form.getMtgId(), form.getUserId());
        if (mu == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "用户不许参加该会议");
        }

        MeetingUser rm = new MeetingUser();
        rm.setMuId(mu.getMuId());
        rm.setSignWay(form.getSignWay());
        rm.setStatus(MeetingConsts.USER_SIGNIN);
        rm.setSignTime(new Date());
        int i = meetingUserDAO.updateByPrimaryKeySelective(rm);
        if (i < 1) {
            return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "签到失败");
        }

        return ResultUtils.successBean();
    }
}
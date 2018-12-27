package com.dwms.activity.service.impl;

import com.dwms.activity.consts.ActivityConsts;
import com.dwms.activity.dao.IActivityDAO;
import com.dwms.activity.dao.IActivityUserDAO;
import com.dwms.activity.model.bean.Activity;
import com.dwms.activity.model.bean.ActivityUser;
import com.dwms.activity.model.form.ApplyForm;
import com.dwms.activity.model.form.DetailForm;
import com.dwms.activity.model.form.ListForm;
import com.dwms.activity.model.vo.ActCountVO;
import com.dwms.activity.model.vo.ActivityVO;
import com.dwms.activity.service.IActivityService;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.HtmlUtils;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.vo.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 活动服务
 * @author windy
 * @date 2018-12-05
 */
@Service
public class ActivityService implements IActivityService {

    @Resource
    private IActivityDAO activityDAO;
    @Resource
    private IActivityUserDAO activityUserDAO;
    @Resource
    private IUserDAO userDAO;

    @Override
    public ResultBean getDetail(DetailForm form) {
        Activity a = activityDAO.selectByPrimaryKey(form.getActId());
        if (a == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "活动不存在");
        } else if (a.getStatus() == ActivityConsts.STATUS_CLOSE || a.getStatus() == ActivityConsts.STATUS_WAITING) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "活动不存在");
        }

        int apply = 0;//报名成功 0否 1是
        if (StringUtils.isNotBlank(form.getUserId())) {
            ActivityUser au = activityUserDAO.selectByActIdAndUserId(form.getActId(), form.getUserId(), ActivityConsts.USER_STATUS_APPLY);
            if (au != null) {
                apply = 1;
            }
        }

        List<UserVO> applys = activityUserDAO.selectByActId(form.getActId(), ActivityConsts.USER_STATUS_APPLY);
        a = HtmlUtils.activity(a);

        //返回数据
        Map<String, Object> data = Maps.newHashMap();
        data.put(ActivityConsts.ACTIVITY, a);
        data.put("apply", apply);
        data.put("applys", applys);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean getList(Page<ActivityVO> page, ListForm form) {
        UserVO u = userDAO.selectById(form.getUserId());
        if (u == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (u.getPartyId() == null) {
            return ResultUtils.successBean();
        }

        form.setPartyId(u.getPartyId());
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> activityDAO.selectSelective(form));

        if (!page.isEmpty()) {
            List<ActivityVO> acts = page.getResult();
            acts = status(acts);
            acts = HtmlUtils.activity(acts);
            List<Integer> actIds = Lists.newArrayList();
            for (ActivityVO a : acts) {
                actIds.add(a.getActId());
            }
            List<ActCountVO> counts = activityUserDAO.countList(actIds);
            for (ActivityVO a : acts) {
                for (ActCountVO ac : counts) {
                    if (ac.getActId().equals(a.getActId())) {
                        a.setNums(ac.getNums());
                        break;
                    }
                }
                if (a.getNums() == null) {
                    a.setNums(0);
                }
            }
            HtmlUtils.activity(acts);
        }
        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean updApply(ApplyForm form) {
        Activity a = activityDAO.selectByPrimaryKey(form.getActId());
        if (a == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "活动不存在");
        } else if (a.getStatus() == ActivityConsts.STATUS_CLOSE || a.getStatus() == ActivityConsts.STATUS_WAITING) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "活动不存在");
        } else if (a.getApplyEndTime().getTime() < System.currentTimeMillis()) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "已过截止报名时间，不能再修改");
        }

        ActivityUser au = activityUserDAO.selectByActIdAndUserId(form.getActId(), form.getUserId(), ActivityConsts.USER_STATUS_APPLY);
        if (form.getStatus() == ActivityConsts.USER_STATUS_CANCEL && au != null) {
            activityUserDAO.updateStatus(au.getAuId(), ActivityConsts.USER_STATUS_CANCEL);
        } else if (form.getStatus() == ActivityConsts.USER_STATUS_APPLY && au == null) {
            au = new ActivityUser();
            au.setActId(form.getActId());
            au.setUserId(form.getUserId());
            au.setStatus(ActivityConsts.USER_STATUS_APPLY);
            activityUserDAO.insertSelective(au);
        }
        return ResultUtils.successBean();
    }

    /**
     * 处理状态
     * @author windy
     * @date 2018-12-05
     */
    private List<ActivityVO> status(List<ActivityVO> as) {
        if (CollectionUtils.isEmpty(as)) {
            return as;
        }

        long now = System.currentTimeMillis();
        for (ActivityVO a : as) {
            if (a.getEndTime().getTime() < now) {
                a.setStatus(ActivityConsts.VO_STATUS_END);
            } else if (a.getBeginTime().getTime() > now) {
                a.setStatus(ActivityConsts.VO_STATUS_ONGOING);
            } else if (a.getStatus() != null && a.getStatus() == ActivityConsts.USER_STATUS_APPLY) {
                a.setStatus(ActivityConsts.VO_STATUS_APPLY);
            } else {
                a.setStatus(ActivityConsts.VO_STATUS_WAITING);
            }
        }
        return as;
    }
}

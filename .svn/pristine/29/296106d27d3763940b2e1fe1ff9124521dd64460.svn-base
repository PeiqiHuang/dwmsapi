package com.dwms.msg.service.impl;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.course.consts.CourseConsts;
import com.dwms.due.consts.DueConsts;
import com.dwms.msg.dao.IMatterDAO;
import com.dwms.msg.model.vo.MatterVO;
import com.dwms.msg.service.IMatterService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 最近事务服务
 * @author windy
 * @date 2018-12-20
 */
@Service
public class MatterService implements IMatterService {

    @Resource
    private IMatterDAO matterDAO;

    @Override
    public ResultBean recent(UserIdForm form) {
        List<MatterVO> ms = CacheUtils.get(CacheConsts.MSG_MATTER, form.getUserId(), List.class);
        if (CollectionUtils.isEmpty(ms)) {
            getRecent(form.getUserId());
        }
        ms = CacheUtils.get(CacheConsts.MSG_MATTER, form.getUserId(), List.class);
        int matterNums = CacheUtils.get(CacheConsts.MSG_MATTER, form.getUserId() + "_nums", Integer.class);

        Map<String, Object> data = Maps.newHashMap();
        data.put("nums", matterNums);
        data.put("matters", ms);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean list(UserIdForm form) {
        return ResultUtils.successBean(getRecent(form.getUserId()));
    }

    /**
     * 更新最近事务
     * @author windy
     * @date 2018-12-20
     */
    private List<MatterVO> getRecent(String userId) {
        List<MatterVO> ms = matterDAO.selectMeeting(userId);
        List<MatterVO> ds = matterDAO.selectDue(userId);
        for (MatterVO d : ds) {
            if (d.getStatus() == DueConsts.USER_STATUS_CONFIRM) {
                d.setStatus(DueConsts.USER_STATUS_PAID);
            }
        }
        List<MatterVO> es = matterDAO.selectExamine(userId);
        List<MatterVO> cs = matterDAO.selectCourse(userId);
        for (MatterVO c : cs) {
            if (c.getStatus() == CourseConsts.USER_STATUS_NOT) {
                c.setStatus(CourseConsts.USER_STATUS_GOING);
            }
        }

        ms.addAll(ds);
        ms.addAll(cs);
        ms.addAll(es);

        //处理最近事务
        int matterNums = ms.size();
        if (CollectionUtils.isNotEmpty(ms)) {
            ms.sort((o1, o2) -> (int) (o1.getBeginTime().getTime() - o2.getBeginTime().getTime()));
        }

        List<MatterVO> index = Lists.newArrayList();//首页展示的最近事务
        if (ms.size() > 1) {
            index.add(ms.get(0));
            index.add(ms.get(1));
        } else {
            index = ms;
        }

        CacheUtils.put(CacheConsts.MSG_MATTER, userId, index);
        CacheUtils.put(CacheConsts.MSG_MATTER, userId + "_nums", matterNums);
        return ms;
    }

}

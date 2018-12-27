package com.dwms.activity.service;

import com.dwms.activity.model.form.ApplyForm;
import com.dwms.activity.model.form.DetailForm;
import com.dwms.activity.model.form.ListForm;
import com.dwms.activity.model.vo.ActivityVO;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;

/**
 * 活动服务
 * @author windy
 * @date 2018-12-06
 */
public interface IActivityService {

    /**
     * 活动详情
     * @author windy
     * @date 2018-12-06
     */
    ResultBean getDetail(DetailForm form);

    /**
     * 活动列表
     * @author windy
     * @date 2018-12-06
     */
    ResultBean getList(Page<ActivityVO> page, ListForm form);

    /**
     * 报名
     * @author windy
     * @date 2018-12-06
     */
    ResultBean updApply(ApplyForm form);
}

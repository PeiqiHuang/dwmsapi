package com.dwms.due.service;

import com.dwms.common.model.ResultBean;
import com.dwms.due.model.form.ConfirmForm;
import com.dwms.due.model.form.DetailForm;
import com.dwms.due.model.form.ListForm;
import com.dwms.due.model.vo.DueVO;
import com.github.pagehelper.Page;

/**
 * 党费服务
 * @author windy
 * @date 2018-12-17
 */
public interface IDueService {

    /**
     * 党费详情
     * @author windy
     * @date 2018-12-18
     */
    ResultBean detail(DetailForm form);

    /**
     * 党费列表
     * @author windy
     * @date 2018-12-18
     */
    ResultBean list(Page<DueVO> page, ListForm form);

    /**
     * 确认缴费
     * @author windy
     * @date 2018-12-18
     */
    ResultBean updConfirm(ConfirmForm form);
}

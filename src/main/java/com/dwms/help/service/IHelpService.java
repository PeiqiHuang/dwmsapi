package com.dwms.help.service;

import com.dwms.common.model.ResultBean;
import com.dwms.help.model.form.DetailForm;
import com.dwms.help.model.form.ListForm;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 10:22
 * @Description: 帮助中心Service接口
 */
public interface IHelpService {

    /**
     * 帮助信息列表
     * @author yunbin
     * @date 2018-12-17
     */
    ResultBean getList(ListForm form);

    /**
     * 帮助信息详情
     * @author yunbin
     * @date 2018-12-17
     */
    ResultBean getDetail(DetailForm form);
}

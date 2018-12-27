package com.dwms.msg.service;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.model.ResultBean;

/**
 * 最近事务服务
 * @author windy
 * @date 2018-12-20
 */
public interface IMatterService {

    /**
     * 待办事务
     * @author windy
     * @date 2018-12-20
     */
    ResultBean recent(UserIdForm form);

    /**
     * 最近事务列表
     * @author windy
     * @date 2018-12-20
     */
    ResultBean list(UserIdForm form);
}

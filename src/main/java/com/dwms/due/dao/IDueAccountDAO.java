package com.dwms.due.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.due.model.bean.DueAccount;
import org.apache.ibatis.annotations.Param;

/**
 * 党费账户DAO接口
 * @author windy
 * @date 2018-12-18
 */
public interface IDueAccountDAO extends BaseMapper<DueAccount> {

    /**
     * 查询账户信息
     * @author windy
     * @date 2018-12-18
     */
    DueAccount selectByAccId(@Param("accId") Integer accId);

}

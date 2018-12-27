package com.dwms.base.dao;

import com.dwms.base.model.bean.Version;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 版本信息DAO
 * @author windy
 * @date 2018-11-16
 */
public interface IVersionDAO extends BaseMapper<Version> {

    /**
     * 最新版本
     * @author windy
     * @date 2018-11-26
     */
    Version selectLast(@Param("appCode") String appCode, @Param("status") Integer status);

}

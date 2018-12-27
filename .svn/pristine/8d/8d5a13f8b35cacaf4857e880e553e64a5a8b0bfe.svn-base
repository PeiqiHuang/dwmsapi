package com.dwms.base.dao;

import com.dwms.base.model.bean.District;
import com.dwms.base.model.form.DistListForm;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地区DAO
 * @author windy
 * @date 2018-11-16
 */
public interface IDistDAO extends BaseMapper<District> {

    /**
     * 查询地区
     * @author windy
     * @date 2018-11-19
     */
    List<District> selectSelective(@Param("form") DistListForm form);

    /**
     * 查询地区：时间增量
     * @author windy
     * @date 2018-11-19
     */
    List<District> selectIncrease(@Param("date") String date);

}

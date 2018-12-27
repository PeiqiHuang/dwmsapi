package com.dwms.activity.dao;

import com.dwms.activity.model.bean.Activity;
import com.dwms.activity.model.form.ListForm;
import com.dwms.activity.model.vo.ActivityVO;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动信息DAO接口
 * @author windy
 * @date 2018-12-05
 */
public interface IActivityDAO extends BaseMapper<Activity> {

    /**
     * 活动列表
     * @author windy
     * @date 2018-12-05
     */
    List<ActivityVO> selectSelective(@Param("form") ListForm form);

}
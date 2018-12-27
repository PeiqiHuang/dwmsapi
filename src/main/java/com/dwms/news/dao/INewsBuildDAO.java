package com.dwms.news.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.news.model.bean.NewsBuild;
import com.dwms.news.model.form.ListForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 党建要闻DAO接口
 * @author windy
 * @date 2018-12-11
 */
public interface INewsBuildDAO extends BaseMapper<NewsBuild> {

    /**
     * 党建要闻列表
     * @author windy
     * @date 2018-12-12
     */
    List<NewsBuild> selectSelective(@Param("form")ListForm form);

}

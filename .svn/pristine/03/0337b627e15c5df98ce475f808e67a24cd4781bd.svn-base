package com.dwms.base.dao;

import com.dwms.base.model.bean.Advert;
import com.dwms.base.model.form.AdvertForm;
import com.dwms.base.model.vo.AdvertVO;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 广告DAO接口
 * @author windy
 * @date 2018-11-23
 */
public interface IAdvertDAO extends BaseMapper<Advert> {

    /**
     * 广告列表
     * @author windy
     * @date 2018-11-26
     */
    List<AdvertVO> selectSelective(@Param("form") AdvertForm form);
}

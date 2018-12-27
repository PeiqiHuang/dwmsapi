package com.dwms.birthday.dao;

import com.dwms.birthday.model.bean.WishTemp;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yunbin
 * @Date: 2018/12/13 15:40
 * @Description: 政治生日祝福模板DAO接口
 */
public interface IWishTempDAO extends BaseMapper<WishTemp> {

    /**
     * 获取生日祝福模板
     * @author yunbin
     * @date 2018-12-13
     */
    List<WishTemp> selectByPartyId(@Param("partyId") Integer partyId);
}

package com.dwms.birthday.dao;

import com.dwms.birthday.model.bean.BirthdayWish;
import com.dwms.birthday.model.form.RecentBirthForm;
import com.dwms.birthday.model.form.WishListForm;
import com.dwms.birthday.model.vo.BirthdayVO;
import com.dwms.birthday.model.vo.WishVO;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yunbin
 * @Date: 2018/12/13 15:40
 * @Description: 政治生日祝福DAO接口
 */
public interface IBirthdayWishDAO extends BaseMapper<BirthdayWish> {

    /**
     * 获取近期政治生日
     * @author yunbin
     * @date 2018-12-13
     */
    List<BirthdayVO> selectBirthByPartyId(@Param("form") RecentBirthForm form);

    /**
     * 获取生日祝福
     * @author yunbin
     * @date 2018-12-14
     */
    List<WishVO> selectWish(@Param("form") WishListForm form);
}

package com.dwms.birthday.service;

import com.dwms.birthday.model.form.RecentBirthForm;
import com.dwms.birthday.model.form.WishForm;
import com.dwms.birthday.model.form.WishListForm;
import com.dwms.birthday.model.form.WishTempForm;
import com.dwms.birthday.model.vo.BirthdayVO;
import com.dwms.birthday.model.vo.WishVO;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;

/**
 * 政治生日Service接口
 * @author yunbin
 * @date 2018-12-13
 */
public interface IBirthdayService {

    /**
     * 送生日祝福
     * @author yunbin
     * @date 2018-12-13
     */
    ResultBean addWish(WishForm form);

    /**
     * 获取祝福模板
     * @author yunbin
     * @date 2018-12-13
     */
    ResultBean getWishTemp(WishTempForm form);

    /**
     * 获取近期政治生日
     * @author yunbin
     * @date 2018-12-13
     */
    ResultBean getRecentBirth(Page<BirthdayVO> page, RecentBirthForm form);

    /**
     * 获取祝福列表
     * @author yunbin
     * @date 2018-12-14
     */
    ResultBean getWishList(Page<WishVO> page, WishListForm form);
}

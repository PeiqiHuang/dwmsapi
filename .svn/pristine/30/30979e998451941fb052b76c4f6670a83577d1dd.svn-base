package com.dwms.birthday.controller;

import com.dwms.birthday.model.form.RecentBirthForm;
import com.dwms.birthday.model.form.WishForm;
import com.dwms.birthday.model.form.WishListForm;
import com.dwms.birthday.model.form.WishTempForm;
import com.dwms.birthday.model.vo.BirthdayVO;
import com.dwms.birthday.model.vo.WishVO;
import com.dwms.birthday.service.IBirthdayService;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 政治生日Controller
 * @author yunbin
 * @date 2018-12-13
 */
@Controller
@RequestMapping("/birth/")
public class BirthdayController {

    @Resource
    private IBirthdayService birthdayService;

    /**
     * 送生日祝福
     * @author yunbin
     * @date 2018-12-13
     */
    @RequestMapping(value = "wish.do")
    @ResponseBody
    public ResultBean wish(@Valid WishForm form) {
        return birthdayService.addWish(form);
    }

    /**
     * 获取祝福模板
     * @author yunbin
     * @date 2018-12-13
     */
    @RequestMapping(value = "wishTemp.do")
    @ResponseBody
    public ResultBean wishTemp(@Valid WishTempForm form) {
        return birthdayService.getWishTemp(form);
    }

    /**
     * 获取近期政治生日
     * @author yunbin
     * @date 2018-12-13
     */
    @RequestMapping(value = "recentBirth.do")
    @ResponseBody
    public ResultBean recentBirth(Page<BirthdayVO> page, @Valid RecentBirthForm form) { return birthdayService.getRecentBirth(page, form); }

    /**
     * 获取祝福列表
     * @author yunbin
     * @date 2018-12-14
     */
    @RequestMapping(value = "wishList.do")
    @ResponseBody
    public ResultBean wishList(Page<WishVO> page, @Valid WishListForm form) { return birthdayService.getWishList(page, form); }
}

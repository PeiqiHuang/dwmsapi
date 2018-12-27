package com.dwms.birthday.service.impl;

import com.dwms.birthday.dao.IBirthdayWishDAO;
import com.dwms.birthday.dao.IWishTempDAO;
import com.dwms.birthday.model.bean.BirthdayWish;
import com.dwms.birthday.model.bean.WishTemp;
import com.dwms.birthday.model.form.RecentBirthForm;
import com.dwms.birthday.model.form.WishForm;
import com.dwms.birthday.model.form.WishListForm;
import com.dwms.birthday.model.form.WishTempForm;
import com.dwms.birthday.model.vo.BirthdayVO;
import com.dwms.birthday.model.vo.WishVO;
import com.dwms.birthday.service.IBirthdayService;
import com.dwms.common.config.ImageConfig;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.DateUtils;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.SpringUtils;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.vo.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 政治生日Service实现
 * @author yunbin
 * @date 2018-12-13
 */

@Service
public class BirthdayService implements IBirthdayService {

    @Resource
    private IBirthdayWishDAO birthdayWishDAO;
    @Resource
    private IWishTempDAO wishTempDAO;
    @Resource
    private IUserDAO userDAO;


    @Override
    public ResultBean addWish(WishForm form) {
        UserVO fu = userDAO.selectById(form.getUserId());
        if (fu == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        }
        UserVO tu = userDAO.selectById(form.getUserId());
        if (tu == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND, "被祝福人用户不存在");
        }
        BirthdayWish wish = new BirthdayWish();
        wish.setFromUserId(form.getUserId());
        wish.setToUserId(form.getToUserId());
        wish.setWishText(form.getWishText());
        wish.setWishType(form.getWishType());

        // 获取此次生日年份
        Calendar cal = Calendar.getInstance();
        cal.setTime(tu.getFullTime());
        int birthMonth = cal.get(Calendar.MONTH);

        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        // 出生月份小于当前月份，说明生日在明年
        if (birthMonth < month) {
            year += 1;
        }
        wish.setWishYear(year);

        birthdayWishDAO.insertSelective(wish);
        return ResultUtils.successBean();
    }

    @Override
    public ResultBean getWishTemp(WishTempForm form) {
        List<WishTemp> temps = wishTempDAO.selectByPartyId(form.getPartyId());

        if (temps == null || temps.size() < 1) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "祝福模板不存在");
        }
        //返回数据
        Map<String, Object> data = Maps.newHashMap();

        // 随机获取一条祝福模板
        int loc = new Random().nextInt(temps.size());
        data.put("wishTemp", temps.get(loc));

        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean getRecentBirth(Page<BirthdayVO> page, RecentBirthForm form) {
        String beginDate = DateUtils.formatDate(new Date(), "MMdd");
        form.setBeginDate(beginDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, form.getDays());
        String endDate = DateUtils.formatDate(cal.getTime(), "MMdd");
        form.setEndDate(endDate);

        // 时间段是否跨年
        if (beginDate.compareTo(endDate) > 0) {
            form.setRangeType(1);
        } else {
            form.setRangeType(0);
        }

        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> birthdayWishDAO.selectBirthByPartyId(form));

        //静态获取图片配置
        final ImageConfig imageConfig = SpringUtils.getBean(ImageConfig.class);
        // 处理用户头像
        List<BirthdayVO> births = page.getResult();
        if (!CollectionUtils.isEmpty(births)) {
            for (BirthdayVO birth : births) {
                if (StringUtils.isNotBlank(birth.getAvatar())) {
                    birth.setAvatar(imageConfig.getAccessPath() + birth.getAvatar());
                }
            }
        }

        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean getWishList(Page<WishVO> page, WishListForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> birthdayWishDAO.selectWish(form));

        //静态获取图片配置
        final ImageConfig imageConfig = SpringUtils.getBean(ImageConfig.class);
        // 处理用户头像
        List<WishVO> wishes = page.getResult();
        if (!CollectionUtils.isEmpty(wishes)) {
            for (WishVO wish : wishes) {
                if (StringUtils.isNotBlank(wish.getFromUserAvatar())) {
                    wish.setFromUserAvatar(imageConfig.getAccessPath() + wish.getFromUserAvatar());
                }
            }
        }

        return ResultUtils.successBean(PageUtils.map(page));
    }
}

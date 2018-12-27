package com.dwms.user.controller;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.component.sms.SmsUtils;
import com.dwms.common.config.ImageConfig;
import com.dwms.common.config.SysConfig;
import com.dwms.common.consts.EnvEnum;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.consts.SysConsts;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.SpringUtils;
import com.dwms.common.util.UUIDUtils;
import com.dwms.common.util.encrypt.AESUtils;
import com.dwms.common.util.encrypt.MD5Utils;
import com.dwms.user.consts.UserConsts;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.bean.User;
import com.dwms.user.model.form.LoginForm;
import com.dwms.user.model.form.ResetForm;
import com.dwms.user.model.form.UpdForm;
import com.dwms.user.model.vo.UserVO;
import com.dwms.user.service.IUserService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

/**
 * 用户Controller
 * @author windy
 * @date 2018-11-28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private SysConfig sysConfig;
    @Resource
    private ImageConfig imageConfig;

    /**
     * 用户注册（测试）
     * @author windy
     * @date 2018-11-29
     */
    @RequestMapping("/testSave.do")
    @ResponseBody
    public ResultBean testSave(@RequestParam String mobile, @RequestParam String userName) {
        IUserDAO userDAO = SpringUtils.getBean(IUserDAO.class);
        //用户是否存在
        UserVO vo = userDAO.selectByMobile(mobile);

        if (vo == null) {
            User user = new User();
            user.setUserId(UUIDUtils.generateUUID());
            user.setUserName(userName);
            user.setMobile(mobile);
            user.setPassword(MD5Utils.md5("a12345678", user.getUserId()));
            user.setGender(1);
            user.setWorkStatus(2);
            user.setPartyId(1);
            user.setPartyType(5);
            user.setPartyPosts("书记");
            user.setProbationaryTime(DateUtils.addDays(new Date(), -365));
            user.setFullTime(new Date());
            user.setSource("testSave");
            user.setStatus(1);
            userDAO.insertSelective(user);
            vo = userDAO.selectByMobile(mobile);
        }
        Map<String, Object> data = Maps.newHashMap();
        data.put(UserConsts.USER, vo);
        return ResultUtils.successBean(data);
    }

    /**
     * 用户信息
     * @author windy
     * @date 2018-11-29
     */
    @RequestMapping("/get.do")
    @ResponseBody
    public ResultBean get(@Valid UserIdForm form) {
        return userService.get(form);
    }

    /**
     * 登录
     * @author windy
     * @date 2018-11-29
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public ResultBean login(@Valid LoginForm form) {
        String password = AESUtils.decrypt(form.getPassword(), sysConfig.getAppAES());
        System.out.println(password);
        if (password == null) {
            return ResultUtils.errorBean(StatusEnum.USER_PWD_NOTMATCH);
        } else if (!password.matches(SysConsts.PASSWORD_PATTERN)) {
            if (!EnvEnum.TEST.current() || !"123456".equals(password)) {
                return ResultUtils.errorBean(StatusEnum.USER_PWD_NOTMATCH);
            }
        }

        form.setPassword(password);
        return userService.login(form);
    }

    /**
     * 重设密码
     * @author windy
     * @date 2018-11-29
     */
    @RequestMapping("/reset.do")
    @ResponseBody
    public ResultBean reset(@Valid ResetForm form) {
        String password = AESUtils.decrypt(form.getPassword(), sysConfig.getAppAES());
        if (password == null || !password.matches(SysConsts.PASSWORD_PATTERN)) {
            return ResultUtils.errorBean(StatusEnum.USER_PWD_NOTMATCH);
        }
        form.setPassword(password);

        //校验短信验证码
        if (!SmsUtils.verify(form.getMobile(), form.getSmsCode())) {
            return ResultUtils.errorBean(StatusEnum.SMS_CODE_ERROR);
        }

        return userService.reset(form);
    }

    /**
     * 修改信息
     * @author windy
     * @date 2018-11-29
     */
    @RequestMapping("/upd.do")
    @ResponseBody
    public ResultBean upd(@Valid UpdForm form) {
        return userService.upd(form);
    }

}

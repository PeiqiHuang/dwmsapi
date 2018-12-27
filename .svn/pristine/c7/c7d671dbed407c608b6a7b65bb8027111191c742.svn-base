package com.dwms.user.service.impl;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.common.config.ImageConfig;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ImageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.encrypt.MD5Utils;
import com.dwms.common.util.path.CoverUtils;
import com.dwms.user.consts.UserConsts;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.form.LoginForm;
import com.dwms.user.model.form.ResetForm;
import com.dwms.user.model.form.UpdForm;
import com.dwms.user.model.vo.UserVO;
import com.dwms.user.service.IUserService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户Service
 * @author windy
 * @date 2018-11-28
 */
@Service
public class UserService implements IUserService {

    @Resource
    private IUserDAO userDAO;
    @Resource
    private ImageConfig imageConfig;

    @Override
    public ResultBean get(UserIdForm form) {
        //用户是否存在
        UserVO user = userDAO.selectById(form.getUserId());
        if (null == user) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (UserConsts.STATUS_OPEN != user.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        //返回对象
        user = CoverUtils.userAvatar(user);
        Map<String, Object> data = Maps.newHashMap();
        data.put(UserConsts.USER, user);
        return ResultUtils.successBean(data);
    }


    @Override
    public ResultBean login(LoginForm form) {
        //用户是否存在
        UserVO user = userDAO.selectByMobile(form.getMobile());
        if (null == user) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (UserConsts.STATUS_OPEN != user.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        // 检查密码是否正确
        String password = MD5Utils.md5(form.getPassword(), user.getUserId());
        boolean ok = userDAO.check(form.getMobile(), password);
        if (!ok) {
            return ResultUtils.errorBean(StatusEnum.USER_PWD_ERROR);
        }

        //返回对象
        user = CoverUtils.userAvatar(user);
        Map<String, Object> data = Maps.newHashMap();
        data.put(UserConsts.USER, user);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean reset(ResetForm form) {
        //用户是否存在
        UserVO user = userDAO.selectByMobile(form.getMobile());
        if (null == user) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (UserConsts.STATUS_OPEN != user.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }

        //重设密码
        String password = MD5Utils.md5(form.getPassword(), user.getUserId());
        boolean ok = userDAO.reset(form.getMobile(), password);
        if (!ok) {
            return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "重设密码失败");
        }

        return ResultUtils.successBean();
    }

    @Override
    public ResultBean upd(UpdForm form) {
        //用户是否存在
        UserVO user = userDAO.selectById(form.getUserId());
        if (null == user) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        } else if (UserConsts.STATUS_OPEN != user.getStatus()) {
            return ResultUtils.errorBean(StatusEnum.USER_INVALID);
        }
        String userId = user.getUserId();

        //保存图片
        MultipartFile file = form.getAvatarImg();
        if (file != null && !file.isEmpty()) {
            String imageType = file.getContentType();
            imageType = imageType.contains("image/") ? imageType.substring(imageType.indexOf("image/") + 6) : imageType;
            if (!ImageUtils.type(imageType)) {
                return ResultUtils.errorBean(StatusEnum.IMAGE_TYPE_ERROR);
            }

            String savePath = imageConfig.getUploadPath() + imageConfig.getRoot() + imageConfig.getUserAvatar() + "/" + userId.substring(0, 2) + "/";
            String type = ImageUtils.JPG;
            boolean ok = ImageUtils.save(file, savePath, userId, type);
            if (!ok) {
                return ResultUtils.errorBean(StatusEnum.IMAGE_UPLOAD_ERROR);
            }
            String accessPath = imageConfig.getRoot() + imageConfig.getUserAvatar() + "/" + userId.substring(0, 2) + "/" + userId + "." + type;
            form.setAvatar(accessPath);
            user.setAvatar(accessPath);
        }

        //更新
        boolean ok = userDAO.upd(form);
        if (!ok) {
            return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED);
        }

        //性别
        if (form.getGender() != null) {
            user.setGender(form.getGender());
        }
        CoverUtils.userAvatar(user);

        Map<String, Object> data = Maps.newHashMap();
        data.put(UserConsts.USER, user);
        return ResultUtils.successBean(data);
    }
}

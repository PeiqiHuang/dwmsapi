package com.dwms.due.service.impl;

import com.dwms.common.config.ImageConfig;
import com.dwms.common.config.SysConfig;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ImageUtils;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.UUIDUtils;
import com.dwms.common.util.path.CoverUtils;
import com.dwms.due.consts.DueConsts;
import com.dwms.due.dao.IDueAccountDAO;
import com.dwms.due.dao.IDueDAO;
import com.dwms.due.dao.IDueUserDAO;
import com.dwms.due.model.bean.Due;
import com.dwms.due.model.bean.DueAccount;
import com.dwms.due.model.bean.DueUser;
import com.dwms.due.model.form.ConfirmForm;
import com.dwms.due.model.form.DetailForm;
import com.dwms.due.model.form.ListForm;
import com.dwms.due.model.vo.DueVO;
import com.dwms.due.service.IDueService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * 党费项目服务
 * @author windy
 * @date 2018-12-17
 */
@Service
public class DueService implements IDueService {

    @Resource
    private IDueDAO dueDAO;
    @Resource
    private IDueUserDAO dueUserDAO;
    @Resource
    private SysConfig sysConfig;
    @Resource
    private ImageConfig imageConfig;
    @Resource
    private IDueAccountDAO dueAccountDAO;

    @Override
    public ResultBean detail(DetailForm form) {
        Due d = dueDAO.selectByPrimaryKey(form.getDueId());
        if (d == null || d.getStatus() != DueConsts.STATUS_RELEASE) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "该党费项目不存在");
        }
        d.setStatus(null);
        d.setPartyId(null);
        d.setReleaseTime(null);
        d.setCreateTime(null);

        //用户是否缴费
        DueUser du = dueDAO.selectByDueIdAndUserId(d.getDueId(), form.getUserId());
        if (du.getStatus() > DueConsts.USER_STATUS_PAID) {
            du.setStatus(DueConsts.USER_STATUS_PAID);
        }
        CoverUtils.dueUser(du);
        du.setCreateTime(null);

        DueAccount da = dueAccountDAO.selectByAccId(d.getAccId());
        if (da == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "缺失转账账户信息");
        }
        CoverUtils.dueAccount(da);
        da.setCreateTime(null);
        da.setCreateTime(null);

        Map<String, Object> data = Maps.newHashMap();
        data.put("due", d);
        data.put("dueUser", du);
        data.put("account", da);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean list(Page<DueVO> page, ListForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> dueDAO.selectByStatus(form.getUserId(), form.getStatus()));

        if (!page.isEmpty()) {
            for (DueVO d : page.getResult()) {
                if (d.getStatus() > DueConsts.USER_STATUS_PAID) {
                    d.setStatus(DueConsts.USER_STATUS_PAID);
                }
            }
        }

        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean updConfirm(ConfirmForm form) {
        //信息判断
        Due d = dueDAO.selectByPrimaryKey(form.getDueId());
        if (d == null || d.getStatus() != DueConsts.STATUS_RELEASE) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "该党费项目不存在");
        } else if (d.getDueType() == DueConsts.TYPE_FIXED && !d.getDue().equals(form.getDue())) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "该党费项目缴纳数目不对");
        }

        DueUser du = dueDAO.selectByDueIdAndUserId(form.getDueId(), form.getUserId());
        if (du == null) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户不需要缴该党费");
        }
        if (du.getStatus() == DueConsts.USER_STATUS_PAID || du.getStatus() == DueConsts.USER_STATUS_CONFIRM) {
            return ResultUtils.errorBean(StatusEnum.INVALID_PARAM, "用户已经缴该党费");
        }

        DueAccount da = dueAccountDAO.selectByAccId(d.getAccId());
        if (da == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "缺失转账账户信息");
        }

        //保存图片
        DueUser dueUser = new DueUser();
        MultipartFile file = form.getImgPath();
        if (file != null && !file.isEmpty()) {
            String imageType = file.getContentType();
            imageType = imageType.contains("image/") ? imageType.substring(imageType.indexOf("image/") + 6) : imageType;
            if (!ImageUtils.type(imageType)) {
                return ResultUtils.errorBean(StatusEnum.IMAGE_TYPE_ERROR);
            }

            String savePath = imageConfig.getUploadPath() + imageConfig.getRoot() + imageConfig.getDueUser() + "/";
            String type = ImageUtils.JPG;
            boolean ok = ImageUtils.save(file, savePath, String.valueOf(du.getDuId()), type);
            if (!ok) {
                return ResultUtils.errorBean(StatusEnum.IMAGE_UPLOAD_ERROR);
            }
            String accessPath = imageConfig.getRoot() + imageConfig.getDueUser() + "/" + du.getDuId() + "." + type;
            dueUser.setImgPath(accessPath);
        }

        dueUser.setDuId(du.getDuId());
        dueUser.setDue(form.getDue());
        dueUser.setPayWay(form.getPayWay());
        dueUser.setDueTime(new Date());
        dueUser.setStatus(DueConsts.USER_STATUS_PAID);
        dueUserDAO.updateByPrimaryKeySelective(dueUser);

        return ResultUtils.successBean();
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtils.generateUUID());
        System.out.println(UUIDUtils.generateUUID());
    }
}

package com.dwms.advice.service.impl;

import com.dwms.advice.dao.IAdviceDAO;
import com.dwms.advice.model.bean.AdviceInfo;
import com.dwms.advice.model.form.AddForm;
import com.dwms.advice.service.IAdviceService;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: yunbin
 * @Date: 2018/12/18 15:11
 * @Description: 反馈建议Service实现
 */
@Service
public class AdviceService implements IAdviceService {
    @Resource
    private IAdviceDAO adviceDAO;
    @Resource
    private IUserDAO userDAO;

    @Override
    public ResultBean addAdvice(AddForm form) {
        UserVO fu = userDAO.selectById(form.getUserId());
        if (fu == null) {
            return ResultUtils.errorBean(StatusEnum.USER_NOT_FOUND);
        }

        AdviceInfo advice = new AdviceInfo();
        advice.setUserId(form.getUserId());
        advice.setAdviceText(form.getAdviceText());

        adviceDAO.insertSelective(advice);
        return ResultUtils.successBean();
    }
}

package com.dwms.party.service.impl;

import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.CoverUtils;
import com.dwms.party.consts.PartyConsts;
import com.dwms.party.dao.IPartyApplyDAO;
import com.dwms.party.model.bean.PartyApply;
import com.dwms.party.model.form.ApplyForm;
import com.dwms.party.service.IPartyService;
import com.dwms.user.dao.IUserDAO;
import com.dwms.user.model.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 党支部服务
 * @author windy
 * @date 2018-12-02
 */
@Service
public class PartyService implements IPartyService {

    @Resource
    private IPartyApplyDAO partyApplyDAO;
    @Resource
    private IUserDAO userDAO;

    @Override
    public ResultBean saveApply(ApplyForm f) {
        PartyApply a = new PartyApply();
        a.setPartyName(f.getPartyName());
        a.setMemNum(f.getMemNum());
        a.setAddress(f.getAddress());
        a.setContract(f.getContract());
        a.setMobile(f.getMobile());
        a.setEmail(f.getEmail());
        a.setStatus(PartyConsts.AUDITING);
        a.setProvCode(f.getProvCode());
        a.setCityCode(f.getCityCode());
        a.setDistCode(f.getDistCode());
        if (partyApplyDAO.insertSelective(a) < 1) {
            return ResultUtils.errorBean(StatusEnum.OPERATION_FAILED, "申请失败，请重新申请");
        }
        return ResultUtils.successBean();
    }

    @Override
    public ResultBean getUsers(Integer partyId) {
        List<UserVO> us = userDAO.selectByPartyId(partyId);
        us = CoverUtils.userAvatar(us);
        return ResultUtils.successBean(us);
    }
}

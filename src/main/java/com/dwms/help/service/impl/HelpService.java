package com.dwms.help.service.impl;

import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.help.dao.IHelpInfoDAO;
import com.dwms.help.model.form.DetailForm;
import com.dwms.help.model.form.ListForm;
import com.dwms.help.model.vo.HelpInfoVO;
import com.dwms.help.model.vo.HelpTypeVO;
import com.dwms.help.service.IHelpService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 10:22
 * @Description: 帮助中心service实现
 */
@Service
public class HelpService implements IHelpService {

    @Resource
    private IHelpInfoDAO helpInfoDAO;

    @Override
    public ResultBean getList(ListForm form) {

        // 帮助类型列表
        List<HelpTypeVO> typeList = helpInfoDAO.selectHelpType();
        // 帮助信息列表
        List<HelpInfoVO> infoList = helpInfoDAO.selectInfoList();

        for(HelpInfoVO info : infoList) {
            for(HelpTypeVO type : typeList) {
                if (type.getTypeId() == info.getInfoType()) {
                    type.getInfoList().add(info);
                    break;
                }
            }
        }

        //返回数据
        Map<String, Object> data = Maps.newHashMap();
        data.put("typeList", typeList);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean getDetail(DetailForm form) {
        HelpInfoVO info = helpInfoDAO.selectInfo(form);

        //返回数据
        Map<String, Object> data = Maps.newHashMap();
        data.put("info", info);
        return ResultUtils.successBean(data);
    }
}

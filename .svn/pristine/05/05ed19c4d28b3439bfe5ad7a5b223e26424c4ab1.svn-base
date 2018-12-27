package com.dwms.help.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.help.model.bean.HelpInfo;
import com.dwms.help.model.form.DetailForm;
import com.dwms.help.model.vo.HelpInfoVO;
import com.dwms.help.model.vo.HelpTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 10:25
 * @Description: 帮助中心DAO接口
 */
public interface IHelpInfoDAO extends BaseMapper<HelpInfo> {

    /**
     * 帮助类型列表
     * @author yunbin
     * @date 2018-12-17
     */
    List<HelpTypeVO> selectHelpType();

    /**
     * 帮助信息列表
     * @author yunbin
     * @date 2018-12-17
     */
    List<HelpInfoVO> selectInfoList();

    /**
     * 帮助信息详情
     * @author yunbin
     * @date 2018-12-17
     */
    HelpInfoVO selectInfo(@Param("form") DetailForm form);
}

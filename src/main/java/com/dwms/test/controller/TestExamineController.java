package com.dwms.test.controller;

import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.examine.dao.IExamineDAO;
import com.dwms.examine.dao.IExamineQuestionUserDAO;
import com.dwms.examine.dao.IExamineUserDAO;
import com.dwms.examine.model.bean.Examine;
import com.dwms.examine.model.bean.ExamineQuestionUser;
import com.dwms.examine.model.bean.ExamineUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * 考试测试controller
 * @author windy
 * @date 2018-12-21
 */
@Controller
@RequestMapping("/test/examine/")
public class TestExamineController {

    @Resource
    private IExamineUserDAO examineUserDAO;
    @Resource
    private IExamineQuestionUserDAO examineQuestionUserDAO;

    /**
     * 考试测试接口
     * @author windy
     * @date 2018-12-21
     */
    @RequestMapping("clear.do")
    @ResponseBody
    public ResultBean clear(@RequestParam Integer euId) {
        ExamineUser eu = examineUserDAO.selectByPrimaryKey(euId);
        if (eu == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND, "考试不存在");
        }

        eu.setScore(0);
        eu.setTimeLength(0);
        eu.setStatus(-1);
        eu.setFinishTime(null);
        examineUserDAO.updateByPrimaryKey(eu);

        Example e = new Example(ExamineQuestionUser.class);
        e.createCriteria().andEqualTo("euId", euId);
        examineQuestionUserDAO.deleteByExample(e);
        return ResultUtils.successBean();
    }
}

package com.dwms.examine.service;

import com.dwms.common.model.ResultBean;
import com.dwms.examine.model.form.AnswerForm;
import com.dwms.examine.model.form.ListForm;
import com.dwms.examine.model.form.SaveAnswerForm;
import com.dwms.examine.model.vo.ExamineVO;
import com.github.pagehelper.Page;

/**
 * 考试服务
 * @author windy
 * @date 2018-12-17
 */
public interface IExamineService {

    /**
     * 考试详情
     * @author windy
     * @date 2018-12-17
     */
    ResultBean getDetail(Integer examId);

    /**
     * 考试列表
     * @author windy
     * @date 2018-12-17
     */
    ResultBean list(Page<ExamineVO> page, ListForm form);

    /**
     * 考试答案
     * @author windy
     * @date 2018-12-17
     */
    ResultBean getAnswer(AnswerForm form);

    /**
     * 答题
     * @author windy
     * @date 2018-12-17
     */
    ResultBean saveAnswer(SaveAnswerForm form);
}

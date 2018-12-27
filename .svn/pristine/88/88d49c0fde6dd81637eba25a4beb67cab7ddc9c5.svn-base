package com.dwms.examine.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.examine.model.bean.ExamineQuestion;
import com.dwms.examine.model.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考试关联题目DAO接口
 * @author windy
 * @date 2018-12-11
 */
public interface IExamineQuestionDAO extends BaseMapper<ExamineQuestion> {

    /**
     * 问题列表
     * @author windy
     * @date 2018-12-17
     */
    List<QuestionVO> selectQuestion(@Param("examId") Integer examId);

    /**
     * 答案列表
     * @author windy
     * @date 2018-12-17
     */
    List<QuestionVO> selectAnswer(@Param("examId") Integer examId);
}

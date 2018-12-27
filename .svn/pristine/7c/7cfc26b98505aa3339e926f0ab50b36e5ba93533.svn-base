package com.dwms.examine.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.examine.model.bean.ExamineQuestionUser;
import com.dwms.examine.model.vo.AnswerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 具体考试题目关联考试人员DAO接口
 * @author windy
 * @date 2018-12-11
 */
public interface IExamineQuestionUserDAO extends BaseMapper<ExamineQuestionUser> {

    /**
     * 查询答题列表
     * @author windy
     * @date 2018-12-14
     */
    List<AnswerVO> selectAnswer(@Param("examId") Integer examId, @Param("euId") Integer euId);

}

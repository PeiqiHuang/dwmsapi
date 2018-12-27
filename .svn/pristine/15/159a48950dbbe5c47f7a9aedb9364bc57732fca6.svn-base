package com.dwms.examine.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.examine.model.bean.ExamineUser;
import com.dwms.examine.model.vo.CountVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考试人员DAO接口
 * @author windy
 * @date 2018-12-11
 */
public interface IExamineUserDAO extends BaseMapper<ExamineUser> {

    /**
     * 考试人员
     * @author windy
     * @date 2018-12-14
     */
    ExamineUser selectByExamIdAndUserId(@Param("examId") Integer examId, @Param("userId") String userId);

    /**
     * 统计人数
     * @author windy
     * @date 2018-12-14
     */
    List<CountVO> countByExamIds(@Param("examIds") List<Integer> examIds);

}

package com.dwms.examine.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.examine.model.bean.Examine;
import com.dwms.examine.model.form.ListForm;
import com.dwms.examine.model.vo.ExamineVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考试试卷DAO接口
 * @author windy
 * @date 2018-12-13
 */
public interface IExamineDAO extends BaseMapper<Examine> {

    /**
     * 考试信息
     * @author windy
     * @date 2018-12-17
     */
    ExamineVO selectByEuId(@Param("euId") Integer euId);

    /**
     * 考试列表
     * @author windy
     * @date 2018-12-14
     */
    List<ExamineVO> selectSelective(@Param("form") ListForm form);
}

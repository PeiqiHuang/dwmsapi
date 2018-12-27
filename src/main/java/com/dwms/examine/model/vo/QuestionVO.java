package com.dwms.examine.model.vo;

import com.dwms.examine.model.bean.Question;
import lombok.Data;

/**
 * 题目变量
 * @author windy
 * @date 2018-12-14
 */
@Data
public class QuestionVO extends Question {

    private Integer eqId;//考试题目id
    private Integer score;//题目分数
    private Integer quNo;//题目序号 1 2 3...

}

package com.dwms.examine.model.vo;

import com.dwms.examine.model.bean.Question;
import lombok.Data;

/**
 * 考试答案变量
 * @author windy
 * @date 2018-12-14
 */
@Data
public class AnswerVO extends Question {

    private Integer eqId;//考试题目id
    private Integer score;//题目分数
    private Integer winScore;//题目得分
    private Integer quNo;//题目序号 1 2 3...
    private Integer status;//答案状态 -1错误 0待评分 1正确
    private String answer;//回答答案（多选题、多个空的填空题答案分号分隔 A.aaa;B.bbb;...）

}

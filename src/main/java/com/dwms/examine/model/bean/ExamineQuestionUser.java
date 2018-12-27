package com.dwms.examine.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 具体考试题目关联考试人员
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_examine_question_user")
public class ExamineQuestionUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer equId;//题目人员ID

    private Integer eqId;//考试题目ID
    private Integer euId;//考试人员Id,tb_examine_user的euId
    private Integer score;//题目得分
    private String answer;//回答答案（多选题、多个空的填空题答案===分隔 A|||答案1===B|||答案2===...）
    private Integer status;//状态 -1回答错误 0未判分 1已判分/回答正确
}

package com.dwms.examine.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 考试关联题目
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_examine_question")
public class ExamineQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eqId;//考试题目ID

    private Integer examId;//试卷ID
    private Integer quId;//题目ID
    private Integer quNo;//题目序号 1 2 3...
    private Integer score;//题目分数
    private Date createTime;//创建时间
}

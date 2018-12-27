package com.dwms.examine.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 考试人员
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_examine_user")
public class ExamineUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer euId;//考试人员ID

    private Integer examId;//试卷ID
    private String userId;//参与党员
    private Integer score;//考试得分
    private Integer examType;//考试类型  1正考 2补考
    private Integer timeLength;//考试用时（秒）
    private Integer status;//状态  -1未提交 0未通过 1待判分 2已通过
    private Date finishTime;//提交时间
    private Date createTime;//创建时间
}

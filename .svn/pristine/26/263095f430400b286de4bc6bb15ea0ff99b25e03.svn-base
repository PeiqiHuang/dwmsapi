package com.dwms.examine.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 考试题库
 * @author windy
 * @date 2018-12-14
 */
@Data
@Table(name = "tb_question_info")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quId;//题目ID

    private Integer partyId;//党支部ID
    private String title;//题目标题
    private Integer quType;//题目类型 1单选题 2多选题 3填空题 4简答题
    private String answers;//题目答案（选择题选项===分隔 A|||答案1===B|||答案2===...）
    private String rightKey;//正确答案（多选题、多个空的填空题答案===分隔 A|||答案1===B|||答案2===...）
    private String analysis;//答案解析
    private Integer status;//状态 1.有效 0.禁用
    private Date createTime;//创建时间
    private Integer maxNum;//简答题回答最大字数限制
}

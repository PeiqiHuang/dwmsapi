package com.dwms.examine.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 考试试卷
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_examine_info")
public class Examine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examId;//试卷ID

    private Integer partyId;//党支部ID
    private String examName;//考试名称
    private String examDesc;//考试说明
    private Integer totalScore;//总分
    private Integer passScore;//及格分
    private Integer quNum;//总题数(实际添加题目数更新)
    private Integer timeLength;//考试时长（分钟）
    private Integer showType;//显示答案时间 -1不显示 0立即 1.自定义时间
    private Date showTime;//显示答案时间（showType 1 设置）
    private Integer pushMsg;//考试消息app推送 1是 0否
    private Integer endMsg;//考试结束提醒（固定提前多少分钟） 1是 0否
    private String previewer;//预览试卷userId
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date beginTime;//考试开始时间
    private Date endTime;//考试结束时间
    private Date releaseTime;//发布时间
    private Date createTime;//创建时间
}

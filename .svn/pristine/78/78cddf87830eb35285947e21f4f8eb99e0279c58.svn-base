package com.dwms.course.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 微课程
 * @author windy
 * @date 2018-12-06
 */
@Data
@Table(name = "tb_course_info")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;//课程ID

    private Integer partyId;//党支部ID
    private Integer categoryId;//课程分类ID
    private String courseName;//课程名称
    private String courseDesc;//课程简介
    private String cover;//课程封面
    private String banner;//课程详情顶部图片
    private String filePath;//文件地址
    private Integer courseType;//类型 0选修 1必修
    private Integer chapterNum;//总课时
    private Integer timeLength;//总时长（分钟）
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date endTime;//截止日期
    private Date releaseTime;//发布时间
    private Date createTime;//创建时间
}

package com.dwms.course.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程人员
 * @author windy
 * @date 2018-12-06
 */
@Data
@Table(name = "tb_course_chapter_user")
public class CourseChapterUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ccuId;//逻辑ID

    private Integer chapterId;//课程章节ID
    private String userId;//课程参与党员
    private Integer timeLength;//学习时长（分钟）
    private Integer status;//状态 0未完成 1已完成
    private Date finishTime;//完成时间
    private Date createTime;//创建时间
}

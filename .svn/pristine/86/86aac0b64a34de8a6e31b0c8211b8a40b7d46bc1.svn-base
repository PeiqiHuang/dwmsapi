package com.dwms.course.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 微课程章节
 * @author windy
 * @date 2018-12-06
 */
@Data
@Table(name = "tb_course_chapter")
public class CourseChapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chapterId;//课程章节ID

    private Integer parentId;//父级章节ID 为节时才有值
    private Integer courseId;//课程ID
    private Integer chapterNo;//章节序号 0，1，2
    private String chapterTitle;//标题
    private Integer chapterType;//章节类型 1章 2节
    private Integer timeLength;//章节时长（分钟）
    private String content;//内容

}

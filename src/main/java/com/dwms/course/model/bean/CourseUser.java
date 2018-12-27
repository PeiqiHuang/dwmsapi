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
@Table(name = "tb_course_user")
public class CourseUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuId;//逻辑ID

    private Integer courseId;//课程ID
    private String userId;//课程参与党员
    private Integer timeLength;//学习时长（分钟）
    private Integer status;//状态 -1未生效 0已生效（未完成） 1已完成
    private Date finishTime;//完成时间
    private Date createTime;//创建时间
    private Integer progress;//进度，整数，100表示100%
    private Integer restChapter;//剩余课时

}

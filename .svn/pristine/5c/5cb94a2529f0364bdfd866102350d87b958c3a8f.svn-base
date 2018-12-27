package com.dwms.course.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 微课程分类
 * @author windy
 * @date 2018-12-06
 */
@Data
@Table(name = "tb_course_category")
public class CourseCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;//课程分类ID

    private String categoryName;//分类名称
    private Integer status;//状态 1.有效 0.禁用
    private Integer weight;//权重 大的排在前面
    private Integer partyId;//党支部ID
}

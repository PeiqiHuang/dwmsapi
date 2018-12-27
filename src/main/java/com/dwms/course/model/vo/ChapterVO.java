package com.dwms.course.model.vo;

import com.dwms.course.model.bean.CourseChapter;
import lombok.Data;

/**
 * 章节VO
 * @author windy
 * @date 2018-12-10
 */
@Data
public class ChapterVO extends CourseChapter {

    private Integer ccuId;//用户阅读章节id
    private Integer userTimeLength;//用户学习时长（分钟）
    private Integer status;//状态 0未完成 1已完成

}

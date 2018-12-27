package com.dwms.course.model.vo;

import com.dwms.course.model.bean.Course;
import lombok.Data;

/**
 * 详情变量vo
 * @author windy
 * @date 2018-12-07
 */
@Data
public class DetailVO extends Course {

    private Integer userStatus;//状态 -1未生效 0已生效（未完成） 1已完成

}

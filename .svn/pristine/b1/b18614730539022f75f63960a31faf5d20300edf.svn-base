package com.dwms.course.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 我的课程form
 * @author windy
 * @date 2018-12-06
 */
@Data
public class MyForm extends UserIdForm {

    @Range(min = 0, max = 1)
    private Integer status;//状态 0未完成 1已完成，不传查询所有

}

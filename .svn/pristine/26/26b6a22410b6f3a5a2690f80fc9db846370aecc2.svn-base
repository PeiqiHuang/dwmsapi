package com.dwms.course.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Transient;

/**
 * 课程列表form
 * @author windy
 * @date 2018-12-06
 */
@Data
public class ListForm extends UserIdForm {

    @Range(min = 0, max = 1)
    private Integer courseType;//类型 0选修 1必修，不传查询所有

    @Transient
    private Integer partyId;//党支部id,DAO层查询使用

}

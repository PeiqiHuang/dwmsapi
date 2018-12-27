package com.dwms.activity.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 报名form
 * @author windy
 * @date 2018-12-06
 */
@Data
public class ApplyForm extends UserIdForm {

    @NotNull
    private Integer actId;//活动id
    @NotNull
    @Range(min = 0, max = 1)
    private Integer status;//状态 0取消报名 1报名

}

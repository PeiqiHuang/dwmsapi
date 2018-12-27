package com.dwms.due.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 党费收缴列表form
 * @author windy
 * @date 2018-12-17
 */
@Data
public class ListForm extends UserIdForm {

    @NotNull
    private Integer status;//缴费状态 0未缴费 1已缴费
}

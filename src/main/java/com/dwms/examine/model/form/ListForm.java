package com.dwms.examine.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 考试列表form
 * @author windy
 * @date 2018-12-14
 */
@Data
public class ListForm extends UserIdForm {

    @Min(-1)
    @Max(0)
    private Integer status;//状态 -1待考 0已考


}

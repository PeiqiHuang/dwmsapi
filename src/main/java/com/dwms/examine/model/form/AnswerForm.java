package com.dwms.examine.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 考试成绩form
 * @author windy
 * @date 2018-12-14
 */
@Data
public class AnswerForm extends UserIdForm {

    @NotNull
    private Integer euId;//考试id

}

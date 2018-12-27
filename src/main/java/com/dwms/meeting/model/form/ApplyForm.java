package com.dwms.meeting.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 报名form
 * @author windy
 * @date 2018-12-04
 */
@Data
public class ApplyForm extends UserIdForm {

    @NotNull
    private Integer mtgId;//会议id

}

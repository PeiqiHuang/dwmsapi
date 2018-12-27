package com.dwms.meeting.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 已读form
 * @author windy
 * @date 2018-12-05
 */
@Data
public class ReadForm extends UserIdForm {

    @NotNull
    private Integer sumId;//会议纪要id
}

package com.dwms.course.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 课程form
 * @author windy
 * @date 2018-12-07
 */
@Data
public class DetailForm extends UserIdForm {

    @NotNull
    private Integer courseId;//课程id
    @Range(min = 1, max = 2)
    private Integer chapterType;//章节类型 1章 2节
}

package com.dwms.course.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 同步进度form
 * @author windy
 * @date 2018-12-10
 */
@Data
public class SyncForm extends UserIdForm {

    @NotNull
    private Integer chapterId;//课程章节ID
    @NotNull
    private Integer min;//已读分钟

}

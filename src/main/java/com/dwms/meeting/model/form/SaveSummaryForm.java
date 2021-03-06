package com.dwms.meeting.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 保存会议纪要
 * @author windy
 * @date 2018-12-04
 */
@Data
public class SaveSummaryForm extends UserIdForm {

    @NotNull
    private Integer mtgId;//会议id
    @NotBlank
    private String sumTitle;//纪要标题
    @NotBlank
    private String content;//纪要内容
    @NotNull
    @Range(min = 0, max = 1)
    private Integer status;//状态 0待发布 1发布

}

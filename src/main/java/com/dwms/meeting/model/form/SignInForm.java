package com.dwms.meeting.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 报名form
 * @author windy
 * @date 2018-12-04
 */
@Data
public class SignInForm extends UserIdForm {

    @NotNull
    private Integer mtgId;//会议id
    @NotNull
    @Range(min = 1, max = 2)
    private Integer signWay;//签到方式 1自签（扫码） 2代签 3补签
    //    @Pattern(regexp = SysConsts.UUID_PATTERN)
    //    private String signHelper;//代签人用户userId

}

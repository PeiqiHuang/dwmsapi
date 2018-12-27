package com.dwms.base.model.form;

import com.dwms.common.consts.SysConsts;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 用户userId form
 * @author windy
 * @date 2018-11-28
 */
@Data
public class UserIdForm extends SourceForm {

    @NotBlank
    @Pattern(regexp = SysConsts.UUID_PATTERN)
    private String userId;//用户userId

}

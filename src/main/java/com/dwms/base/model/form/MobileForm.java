package com.dwms.base.model.form;

import com.dwms.common.consts.SysConsts;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 手机号码form
 * @author windy
 * @date 2018-11-26
 */
@Data
public class MobileForm extends SourceForm {

    @NotBlank
    @Pattern(regexp = SysConsts.MOBILE_PATTERN)
    private String mobile;//手机号

}



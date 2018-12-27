package com.dwms.user.model.form;

import com.dwms.base.model.form.MobileForm;
import com.dwms.common.consts.SysConsts;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 重设密码
 * @author windy
 * @date 2016-12-07
 */
@Data
public class ResetForm extends MobileForm {

    @NotBlank
    @Pattern(regexp = SysConsts.SMS_CODE_4)
    private String smsCode;//短信校验码
    @NotBlank
    private String password;//新密码

}
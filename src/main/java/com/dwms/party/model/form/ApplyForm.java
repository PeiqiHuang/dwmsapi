package com.dwms.party.model.form;

import com.dwms.base.model.form.BaseForm;
import com.dwms.common.consts.SysConsts;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 党支部申请form
 * @author windy
 * @date 2018-12-02
 */
@Data
public class ApplyForm extends BaseForm {

    @NotBlank
    private String partyName;//党支部名称
    @NotNull
    private Integer memNum;//党组织人数
    @NotBlank
    @Pattern(regexp = SysConsts.DISTRICT_CODE_PATTERN)
    private String provCode;//省级代码
    @Pattern(regexp = SysConsts.DISTRICT_CODE_PATTERN)
    private String cityCode;//市级代码
    @Pattern(regexp = SysConsts.DISTRICT_CODE_PATTERN)
    private String distCode;//区县代码
    @NotBlank
    private String address;//所在地址
    @NotBlank
    private String contract;//联系人
    @NotBlank
    @Pattern(regexp = SysConsts.MOBILE_PATTERN)
    private String mobile;//联系电话
    @NotBlank
    @Email
    private String email;//邮箱

}

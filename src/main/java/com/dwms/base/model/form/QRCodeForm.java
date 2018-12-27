package com.dwms.base.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 二维码表单
 * @author windy
 * @date 2017-03-23
 */
@Data
public class QRCodeForm {

    @NotBlank
    private String projName;//项目名称
    @NotBlank
    private String busType;//业务类型
    @NotBlank
    private String codeVal;//代码值

}
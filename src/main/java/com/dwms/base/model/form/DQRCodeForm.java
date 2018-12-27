package com.dwms.base.model.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 解码二维码串form
 * @author windy
 * @date 2017-04-26
 */
@Data
public class DQRCodeForm {

    @NotBlank
    private String QRCode;//二维码串（包含前缀）

}

package com.dwms.base.model.form;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 广告列表form
 * @author windy
 * @date 2018-11-26
 */
@Data
public class AdvertForm extends BaseForm {

    @ApiParam(name = "adKey", value = "广告位置key", defaultValue = "app_banner")
    private String adKey;//广告位置key

}
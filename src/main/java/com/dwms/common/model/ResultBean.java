package com.dwms.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * 结果返回
 * @author 罗俊标
 * @date 2015-11-10
 */
@Data
@AllArgsConstructor
@ApiModel
public class ResultBean<T> {

    @ApiModelProperty(value = "状态码 0成功", example = "0")
    private String code;//状态码 0成功
    @ApiModelProperty(value = "状态信息", example = "成功")
    private String msg;//状态信息
    @ApiModelProperty(value = "响应数据")
    private Map<String, Object> data;//响应数据

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}

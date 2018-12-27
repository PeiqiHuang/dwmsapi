package com.dwms.common.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 系统枚举
 * @author windy
 * @date 2018-11-26
 */
@Getter
@AllArgsConstructor
public enum SysEnum {

    //状态 0禁用 1启用
    STATUS_CLOSE(0),
    STATUS_OPEN(1);

    private int code;

}

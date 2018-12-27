package com.dwms.base.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 版本枚举
 * @author windy
 * @date 2018-11-26
 */
@Getter
@AllArgsConstructor
public enum VersionEnum {

    //状态 0禁用 1预发布 2发布
    STATUS_CLOSE(0),
    STATUS_READY(1),
    STATUS_RELEASE(2);

    private Integer code;

}

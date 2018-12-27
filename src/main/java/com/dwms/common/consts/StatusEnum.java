package com.dwms.common.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态
 * 接口响应返回的统一状态码，首位为业务模块递增，后三位为状态递增
 * 状态命名以及状态描述须简洁明了
 * @author 罗俊标
 * @date 2016-11-21
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    // 成功
    SUCCESS("0", "成功"),
    SYSTEM_ERROR("1001", "系统错误"),
    REPEAT_REQUEST("1002", "重复请求"),
    INVALID_PARAM("1003", "非法参数"),
    INVALID_SERVICE("1004", "无效接口"),
    INVALID_TOKEN("1005", "无效Token"),
    SIGN_ERROR("1006", "签名错误"),
    TIME_OUT("1007", "请求超时"),
    OUTSIDE_ERROR("1008", "外部接口调用异常"),
    //通用数据库操作错误
    NOT_FOUND("1010", "查询不存在"),
    QUERY_EMPTY("1011", "查询列表为空"),
    OPERATION_FAILED("1012", "插入或更新操作失败"),
    //通用短信错误
    SMS_SEND_FAILED("1020", "短信发送失败"),
    SMS_CODE_ERROR("1021", "短信验证码错误"),
    SMS_CODE_FREQUENTLY("1022", "操作过于频繁，请120秒后重试"),
    //图片
    IMAGE_TYPE_ERROR("1030", "图片格式错误"),
    IMAGE_UPLOAD_ERROR("1031", "图片上传失败"),
    PICCODE_ERROR("1032", "图片验证码错误"),
    //用户模块
    USER_NOT_FOUND("1100", "用户不存在"),
    USER_TIMEOUT("1101", "登录超时"),
    USER_INVALID("1102", "用户被禁用"),
    USER_PWD_ERROR("1103", "用户名或密码错误"),
    USER_PWD_NOTMATCH("1104", "密码不符合要求");

    private String code;
    private String msg;

}

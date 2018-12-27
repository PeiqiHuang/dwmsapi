package com.dwms.common.consts;

/**
 * 系统常量
 * @author windy
 * @date 2018-10-06
 */
public class SysConsts {

    //系统编码
    public static final String CHARSET = "UTF8";
    //换行符
    public static final String LINE_FEED = "\r\n";
    //日期格式
    public static final String[] DATE_PATTERN = new String[]{"yyyyMMdd", "yyyy-MM-dd", "yyyy/MM/dd"};
    //时间格式
    public static final String[] TIME_PATTERN = new String[]{"yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss"};

    // 访问令牌
    public static final String ACCESS_TOKEN = "dw_token";
    // 来源
    public static final String SOURCE = "dw_source";
    // 访问签名
    public static final String SIGNATURE = "dw_signature";
    // 访问时间戳
    public static final String TIMESTAMP = "dw_timestamp";
    // 权限请求检验头
    public static final String AUTHORIZATION = "Authorization";
    // 权限请求检验头部
    public static final String AUTHORIZATION_HEAD = "Bearer ";


    /**
     * ------------------------------方法变量 begin -----------------------------
     */

    //列表数组变量名
    public static final String OBJS = "objs";
    //分页实体变量名
    public static final String PAGE = "page";
    // 数字字符串常量
    public static final String DIGITALS = "0123456789";

    /** ------------------------------方法变量  end  ------------------------------ */

    /**
     * ------------------------------正则表达式 begin ----------------------------
     */

    // 手机号正则表达式
    public static final String MOBILE_PATTERN = "1[3|4|5|7|8|9]\\d{9}";
    // UUID正则表达
    public static final String UUID_PATTERN = "^([a-fA-F0-9]{32})$";
    // 身份证号码正则表达
    public static final String IDCARD_PATTERN = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";
    // 含有8-16位数字和字母的密码
    public static final String PASSWORD_PATTERN = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
    // 验证码正则表达式
    public static final String SMS_CODE_4 = "^\\d{4}$";
    // 验证码正则表达式
    public static final String SMS_CODE_6 = "^\\d{6}$";
    // 邮箱正则表达式
    public static final String EMAIL_PATTERN = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";
    // APP应用版本号正则表达式
    public static final String APP_VERSION_CODE_PATTERN = "^(\\d+\\.){0,}\\d+$";
    // 地区正则表达式
    public static final String DISTRICT_CODE_PATTERN = "^([0-9]{6})$";
    // 图片验证码正则表达式
    public static final String PICCODE_PATTERN = "^\\w{4}$";
    // 日期yyyy-MM-dd正则表达式
    public static final String DATESTRING_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
    // 订单号正则
    public static final String ORDERNO_PATTERN = "^([0-9]{14})$";
    // 银行卡号后6位正则
    public static final String ACCNO_PATTERN = "^([0-9]{6})$";
    // 银行卡号正则
    public static final String FULL_ACCNO_PATTERN = "^([0-9]{19})$";
    // 等级
    public static final String RANKNO_PATTERN = "^[A-Z]$";
    // 机构号
    public static final String ORGNO_PATTERN = "^([0-9]{8})$";
    // 年月正则，如201709
    public static final String DATESTR_PATTERN = "^([0-9]{6})$";


    /** ------------------------------正则表达式  end  ------------------------------ */

    /** ------------------------------自定义二维码 begin ---------------------------- */

    //二维码前缀
    public static final String QR_PREFIX = "chinapost://";
    //项目名称
    public static final String QR_PROJNAME = "dwms";
    //业务类型
    //会议
    public static final String QR_BUSTYPE_MEETING = "meeting";

    /** ------------------------------自定义二维码  end  ---------------------------- */

}

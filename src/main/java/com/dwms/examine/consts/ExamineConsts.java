package com.dwms.examine.consts;

/**
 * 考试常量
 * @author windy
 * @date 2018-12-14
 */
public class ExamineConsts {

    public static final String EXAMINE = "examine";//对象名
    public static final String SPLIT_OPTION = "===";//选项分隔符号
    public static final String SPLIT_SERIAL = "|||";//序号分隔符号

    //显示答案时间 -1不显示 0立即 1自定义时间
    public static final int SHOWTYPE_HIDDEN = -1;
    public static final int SHOWTYPE_SHOW = 0;
    public static final int SHOWTYPE_RIGHT = 1;

    //考试消息app推送 1是 0否
    public static final int PUSHMSG_NO = -1;
    public static final int PUSHMSG_YES = -1;


    //考试结束提醒（固定提前多少分钟） 1是 0否
    public static final int ENDMSG_NO = 0;
    public static final int ENDMSG_YES = 1;

    //状态 -9已删除 -1已取消 0待发布 1已发布
    public static final int STATUS_CLOSE = -9;
    public static final int STATUS_CANCEL = -1;
    public static final int STATUS_WAITING = 0;
    public static final int STATUS_RELEASE = 1;

    //考试类型  1正考 2补考
    public static final int USER_EXAMTYPE_FORMAL = 1;
    public static final int USER_EXAMTYPE_MAKEUP = 2;

    //状态  -1未提交 0未通过 1待判分 2已通过
    public static final int USER_STATUS_NOTSTART = -1;
    public static final int USER_STATUS_FAIL = 0;
    public static final int USER_STATUS_WAITING = 1;
    public static final int USER_STATUS_SUCCESS = 2;

    //题目类型 1单选题 2多选题 3填空题 4简答题
    public static final int QUESTION_QUTYPE_SINGLE = 1;
    public static final int QUESTION_QUTYPE_MULTI = 2;
    public static final int QUESTION_QUTYPE_BLANK = 3;
    public static final int QUESTION_QUTYPE_ANSWER = 4;

    //状态 -1错误 0未判分 1已判分
    public static final int QUESTION_USER_STATUS_ERROR = -1;
    public static final int QUESTION_USER_STATUS_WAITING = 0;
    public static final int QUESTION_USER_STATUS_SUCCESS = 1;

    //状态 1有效 0禁用
    public static final int QUESTION_STATUS_OPEN = 1;
    public static final int QUESTION_STATUS_CLOSE = 0;

}

package com.dwms.meeting.consts;

/**
 * 会议常量
 * @author windy
 * @date 2018-12-03
 */
public class MeetingConsts {

    //状态 -9已删除 -1已取消 0待发布 1已发布
    public static final int INFO_STATUS_CLOSE = -9;
    public static final int INFO_STATUS_CANCEL = -1;
    public static final int INFO_STATUS_WAITING = 0;
    public static final int INFO_STATUS_RELEASE = 1;

    //会议签到 1是 0否
    public static final int INFO_SIGNIN_YES = 1;
    public static final int INFO_SIGNIN_NO = 0;

    //签到负责人代签或补签 1允许 0禁止
    public static final int INFO_SIGNHELP_YES = 1;
    public static final int INFO_SIGNHELP_NO = 0;

    //会议人员状态 -9请假 -1未确认 0已确认 1已签到
    public static final int USER_OFF = -9;
    public static final int USER_WAITING = -1;
    public static final int USER_CONFIRM = 0;
    public static final int USER_SIGNIN = 1;

    //签到方式 1自签（扫码） 2代签 3补签
    public static final int USER_SIGNWAY_SELF = 1;
    public static final int USER_SIGNWAY_INSTEAD = 2;
    public static final int USER_SIGNWAY_RETROACTIVE = 3;

    //纪要来源 1后台创建 2app创建
    public static final int SUMMARY_SOURCE_PC = 1;
    public static final int SUMMARY_SOURCE_APP = 2;

    //纪要状态 -1已删除 0待发布 1已发布
    public static final int SUMMARY_STATUS_CLOSE = -1;
    public static final int SUMMARY_STATUS_WAITING = 0;
    public static final int SUMMARY_STATUS_RELEASE = 1;

    //纪要人员状态 0未读 1已读
    public static final int SUMMARY_USER_STATUS_NO = 0;
    public static final int SUMMARY_USER_STATUS_READ = 1;


}

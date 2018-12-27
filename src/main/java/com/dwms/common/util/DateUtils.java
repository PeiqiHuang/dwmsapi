package com.dwms.common.util;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/*******************************************************************************
 * 日期工具类
 * 日期操作工具类
 * @author zengxiangtao
 * @version 2013-07-01
 ******************************************************************************/
public class DateUtils {

    public final static String DATE_BAR_FULLTIME = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_PATTEN_FULLTIME = "yyyyMMddHHmmss";
    public final static String DATE_BAR_PATTEN = "yyyy-MM-dd";
    public final static String DATE_PATTEN = "yyyyMMdd";
    public static final long DAY_MILLISECOND = 24 * 60 * 60 * 1000L;//一天毫秒数


    /**
     * 格式化日日期成字符串
     * @author zengxiangtao
     **/
    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 字符串转换成日期格式
     * @author zengxiangtao
     **/
    public static Date strToDate(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 订制日期
     * 10HOUR,11HOUR_OF_DAY,12MINUTE,13SECOND）
     * @prama offset--位移数值
     */
    public static Date getDesignatedDate(Date date, int field, int offset) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(field, offset);
        return calendar.getTime();
    }

    /**
     * 日期大小比较
     * 0:相等;1:fdate比edate大
     */
    public static int compareDate(Date fdate, Date edate) {
        if (fdate.getTime() > edate.getTime()) {
            return 1;
        } else if (fdate.getTime() < edate.getTime()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 是否符合某个日期.
     * @author windy
     * @date 2016-12-11
     */
    public static boolean isMatchPattern(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
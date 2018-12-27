package com.dwms.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 请求工具类
 * @author windy
 * @date 2016-12-01
 */
public class IPUtils {


    public static final int IPV4_LENGTH = 15;//IPV4地址长度

    public static final String UNKNOWN = "unknown";//未知的IP地址

    public static final String LOOPBACK_ADDRESS_IPV4 = "127.0.0.1";//本机回送地址IPV4

    public static final String LOOPBACK_ADDRESS_IPV6 = "0:0:0:0:0:0:0:1";//本机回送地址IPV6

    /**
     * 获取用户真实IP，避免获取的是代理服务的IP
     * 如果为多级反向代理，X-Forwarded-For为一串IP值，真实IP为X-Forwarded-For中第一个非unknown的有效IP字符串。
     * @param request 请求
     * @return IP
     * @author windy
     * @date 2016-12-01
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            //根据网卡取本机配置的IP
            if (ip.equals(LOOPBACK_ADDRESS_IPV4) || ip.equals(LOOPBACK_ADDRESS_IPV6)) {
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        // 对于多个代理的情况，取第一个非UNKNOWN的IP，多个IP按照','分割
        if (ip != null && ip.length() > IPV4_LENGTH) {
            final String[] arr = ip.split(",");
            for (final String str : arr) {
                if (!UNKNOWN.equalsIgnoreCase(str)) {
                    ip = str;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 获取用户真实IP，避免获取的是代理服务的IP（AccessResponseBodyAdvice打印日志用）
     * 如果为多级反向代理，X-Forwarded-For为一串IP值，真实IP为X-Forwarded-For中第一个非unknown的有效IP字符串。
     * @param request 请求
     * @return IP
     * @author windy
     * @date 2016-12-01
     */
    public static String getIpAddr(ServerHttpRequest request) {
        HttpHeaders headers = request.getHeaders();
        String ip = headers.getFirst("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = headers.getFirst("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = headers.getFirst("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = headers.getFirst("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = headers.getFirst("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddress().getAddress().getHostAddress();
            //根据网卡取本机配置的IP
            if (ip.equals(LOOPBACK_ADDRESS_IPV4) || ip.equals(LOOPBACK_ADDRESS_IPV6)) {
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        // 对于多个代理的情况，取第一个非UNKNOWN的IP，多个IP按照','分割
        if (ip != null && ip.length() > IPV4_LENGTH) {
            final String[] arr = ip.split(",");
            for (final String str : arr) {
                if (!UNKNOWN.equalsIgnoreCase(str)) {
                    ip = str;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 判断是否内网IP(TODO:待验证,暂时不可用).
     * @param ip ip地址
     * @author windy
     * @date 2016-12-01
     */
    public static boolean isInner(String ip) {
        String reg = "(10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";//正则表达式=。 =、懒得做文字处理了、
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }

}

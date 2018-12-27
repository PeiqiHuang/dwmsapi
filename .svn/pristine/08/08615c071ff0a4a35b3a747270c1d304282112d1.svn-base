package com.dwms.common.util;

import com.dwms.common.consts.SysConsts;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.*;

/**
 * 请求签名工具类
 * @author 罗俊标
 * @date 2016-11-21
 */
public class SignUtils {

    // 超时毫秒数
    public static final Long TIME_OUT_VALUE = 60 * 60 * 1000L;//一小时

    /**
     * 请求参数转换
     * @author 罗俊标
     * @date 2016-12-13
     */
    public static Map<String, String> conversion(Map map) {
        return conversion(map, null);
    }

    /**
     * 请求参数转换
     * @author 罗俊标
     * @date 2016-11-22
     */
    public static Map<String, String> conversion(Map map, List<String> filterParam) {
        if (null == map || map.size() <= 0) {
            return null;
        }
        Map<String, String> params = new HashMap<>(map.size());
        for (Object o : map.keySet()) {
            String name = (String) o;
            if (null == filterParam || !filterParam.contains(name)) {
                String[] values = (String[]) map.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }
        }
        return params;
    }

    /**
     * 参数字符串转换
     * @author 罗俊标
     * @date 2016-11-22
     */
    public static Map<String, String> convertWithoutSign(Map map) {
        map.remove(SysConsts.ACCESS_TOKEN);
        map.remove(SysConsts.TIMESTAMP);
        map.remove(SysConsts.SIGNATURE);
        return map;
    }


    /**
     * 签名字符串
     * 签名结果
     */
    public static String signParam(String text, String signKey) {
        if (StringUtils.isBlank(text)) {
            return null;
        }
        text = text + signKey;
        return DigestUtils.md5Hex(text.getBytes(Charset.forName(SysConsts.CHARSET)));
    }

    /**
     * 组装参数字符串
     * @author 罗俊标
     * @date 2016-12-13
     */
    public static String paramToStr(Map<String, String> params, List<String> filterParam) {
        // 没有包含签名;或者签名值为空
        if (null == params || params.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        List<String> kl = new ArrayList<>(params.keySet());
        // 排序
        Collections.sort(kl);
        for (String key : kl) {
            String value = params.get(key);
            // 非空值
            if (StringUtils.isNotBlank(value)) {
                // 非过滤参数
                if (null == filterParam || !filterParam.contains(key)) {
                    if (0 == sb.length()) {
                        sb.append(key).append("=").append(value);
                    } else {
                        sb.append("&").append(key).append("=").append(value);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 组装参数字符串
     * @author 罗俊标
     * @date 2016-9-20
     */
    public static String paramToStr(Map<String, String> params) {
        return paramToStr(params, null);
    }

    /**
     * 判断是否超时
     * @author 罗俊标
     * @date 2016-11-21
     */
    public static boolean isTimeOut(Long timestamp) {
        return Math.abs(System.currentTimeMillis() - timestamp) >= TIME_OUT_VALUE;
    }
}
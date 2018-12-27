package com.dwms.common.util;

import com.dwms.common.util.http.Client;
import com.dwms.common.util.http.HTTP;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Http请求工具类
 * @author windy
 * @date 2018-11-21
 */
public class HttpClientUtils {

    private static final String CHARSET = "UTF8";//默认编码

    /**
     * http客户端链接
     * @author windy
     * @date 2018-11-21
     */
    private static Client client() {
        return HTTP.getDefaultHttpClient();
    }

    /**
     * get请求
     * @param url url路径
     * @author windy
     * @date 2018-11-21
     */
    public static String get(String url) {
        return client().get(url, Charset.forName(CHARSET));
    }

    /**
     * get请求
     * @param url     url路径
     * @param charset 编码
     * @author windy
     * @date 2018-11-21
     */
    public static String get(String url, String charset) {
        return client().get(url, Charset.forName(charset));
    }

    /**
     * get请求
     * @param url    请求路径（不带参数）
     * @param params 参数
     * @author windy
     * @date 2018-11-21
     */
    public static String get(String url, Map<String, String> params) {
        return client().get(url, params, Charset.forName(CHARSET));
    }

    /**
     * get请求
     * @param url     请求路径（不带参数）
     * @param params  参数
     * @param charset 编码
     * @author windy
     * @date 2018-11-21
     */
    public static String get(String url, Map<String, String> params, String charset) {
        return client().get(url, params, Charset.forName(charset));
    }

    /**
     * post请求表单数据
     * @param url    请求路径
     * @param params 请求参数
     */
    public static String post(String url, Map<String, String> params) {
        return client().post(url, params, Charset.forName(CHARSET));
    }

    /**
     * post请求表单数据
     * @param url     请求路径
     * @param params  请求参数
     * @param charset 编码
     */
    public static String post(String url, Map<String, String> params, String charset) {
        return client().post(url, params, Charset.forName(charset));
    }

    /**
     * post请求
     * @param url     请求路径
     * @param body    请求内容
     * @param charset 编码
     * @author windy
     * @date 2018-11-21
     */
    public static String post(String url, String body, String charset) {
        return post(url, body, charset, null);
    }

    /**
     * post请求
     * @param url     请求路径
     * @param body    请求内容
     * @param charset 编码
     * @param headers 请求头
     * @author windy
     * @date 2018-11-21
     */
    public static String post(String url, String body, String charset, Map<String, ? extends Object> headers) {
        return client().post(url, body, headers, Charset.forName(charset));
    }

    /**
     * post请求JSON数据
     * @param url     请求路径
     * @param jsonStr 请求内容json字符串
     * @param charset 编码
     * @author windy
     * @date 2018-11-21
     */
    public static String postJSON(String url, String jsonStr, String charset) {
        return client().postJSON(url, jsonStr, Charset.forName(charset));
    }
}
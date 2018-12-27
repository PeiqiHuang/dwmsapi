package com.dwms.common.util.http;

import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.HeaderGroup;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Http client基础操作
 */
public interface Client {

    /**
     * get 请求
     */
    String get(String url, Charset charset);

    /**
     * 携带请求参数的 get 请求
     */
    String get(String url, Map<String, String> params, Charset charset);

    /**
     * post 请求
     */
    String post(String url, Map<String, String> params, Charset charset);

    /**
     * post body的请求
     */
    String post(String url, String body, Charset charset);

    String post(String url, String body, Map<String, ? extends Object> headers, Charset charset);

    HttpResult post2HttpResult(String url, String body, Map<String, ? extends Object> headers, Charset charset);

    String postJSON(String url, String json, Charset charset);

    String postFile(String url, Map<String, String> params, String partName, File partFile, Charset charset);

    CloseableHttpClient getHttpClient();


    /**
     * 请求返回数据
     */
    class HttpResult {

        private HeaderGroup headerGroup = new HeaderGroup();
        private String content;

        public HttpResult(Header[] headers, String content) {
            this.headerGroup.setHeaders(headers);
            this.content = content;
        }

        public HttpResult() {
        }

        public Header[] getHeaders() {
            return headerGroup.getAllHeaders();
        }

        public String getContent() {
            return content;
        }

        public List<Header> getHeaders(String name) {
            return Arrays.asList(headerGroup.getHeaders(name));
        }

        public Header getFirstHeader(String name) {
            return headerGroup.getFirstHeader(name);
        }


        public String getFirstHeaderValue(String name) {
            Header h = getFirstHeader(name);
            return h != null ? h.getValue() : null;
        }
    }
}


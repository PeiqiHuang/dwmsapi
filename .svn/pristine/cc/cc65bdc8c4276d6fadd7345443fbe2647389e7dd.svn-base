package com.dwms.common.util.http;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.IdleConnectionEvictor;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public abstract class AbstractHttpClient implements Client {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * config和cm 唯一性
     */
    private volatile RequestConfig config;
    private volatile PoolingHttpClientConnectionManager cm;
    private int connectTimeout = -1; // 建立连接的时间（不需要太长）
    private int socketTimeout = -1; // 响应时间，读取响应的时间

    /**
     * idle connect evict
     */
    private int maxIdleTime = 10;
    private TimeUnit maxIdleTimeUnit = TimeUnit.SECONDS;

    public AbstractHttpClient() {
    }

    public AbstractHttpClient(int connectTimeout, int socketTimeout) {
        this.connectTimeout = connectTimeout;
        this.socketTimeout = socketTimeout;
    }

    protected RequestConfig getConfig() {
        if (config == null) {
            synchronized (this) {
                if (config == null) {
                    config = getRequestConfig();
                }
            }
        }
        return config;
    }

    protected PoolingHttpClientConnectionManager getCm() {
        if (cm == null) {
            synchronized (this) {
                if (cm == null) {
                    cm = getHttpClientConnectionManager();
                    // evict idle connect.
                    IdleConnectionEvictor connectionEvictor = new IdleConnectionEvictor(cm, maxIdleTime, maxIdleTimeUnit);
                    connectionEvictor.start();
                }
            }
        }
        return cm;
    }


    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    protected RequestConfig getRequestConfig() {
        return RequestConfig.custom()
                // 从连接池获取连接实例的时间
                .setConnectionRequestTimeout(500)
                // 建立连接的时间（不需要太长）
                .setConnectTimeout(getConnectTimeout())
                // 读取响应的时间
                .setSocketTimeout(getSocketTimeout()).build();
    }


    protected PoolingHttpClientConnectionManager getHttpClientConnectionManager() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", getPlainConnectionSocketFactory()).register("https", getSslConnectionSocketFactory()).build();

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);

        cm.setMaxTotal(1000);
        // Increase default max connection per route
        cm.setDefaultMaxPerRoute(50);
        return cm;
    }

    protected PlainConnectionSocketFactory getPlainConnectionSocketFactory() {
        return PlainConnectionSocketFactory.getSocketFactory();
    }


    protected SSLConnectionSocketFactory getSslConnectionSocketFactory() {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContexts.custom().loadTrustMaterial(new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            log.error("Init httpClient pool connect manager Error!!!", e);
            throw new RuntimeException(e);
        }
        return new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
    }

    public abstract CloseableHttpClient getHttpClient();


    @Override
    public String get(String url, Charset charset) {
        HttpGet get = new HttpGet(url);
        return exec(get, null, charset).getContent();
    }

    @Override
    public String get(String url, Map<String, String> params, Charset charset) {
        return get(url + "?" + toLinkString(params), charset);
    }

    @Override
    public String post(String url, Map<String, String> params, Charset charset) {

        HttpPost post = new HttpPost(url);
        List<NameValuePair> valuePairs = new ArrayList<>();
        // 设置请求参数
        if (null != params && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                valuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairs, StandardCharsets.UTF_8);
            post.setEntity(formEntity);
        }
        return exec(post, params, charset).getContent();
    }

    @Override
    public String post(String url, String body, Charset charset) {
        return post(url, body, null, charset);
    }

    @Override
    public String post(String url, String body, Map<String, ?> headers, Charset charset) {
        return post2HttpResult(url, body, headers, charset).getContent();
    }

    @Override
    public HttpResult post2HttpResult(String url, String body, Map<String, ?> headers, Charset charset) {
        // 表示用Post方式提交
        HttpPost post = new HttpPost(url);
        headers(post, headers);
        // 设置请求参数
        StringEntity entity = new StringEntity(body, charset);
        post.setEntity(entity);
        return exec(post, body, charset);
    }


    @Override
    public String postJSON(String url, String json, Charset charset) {
        // 表示用Post方式提交
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        post.addHeader("Accept", "application/json;charset=utf-8");
        // 设置请求参数
        StringEntity entity = new StringEntity(json, charset);
        post.setEntity(entity);
        return exec(post, json, charset).getContent();
    }

    @Override
    public String postFile(String url, Map<String, String> params, String partName, File partFile, Charset charset) {
        // 表示用Post方式提交
        HttpPost post = new HttpPost(url);
        post.addHeader("charset", charset.name());
        // 设置请求参数
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        ContentType contentType = ContentType.create("text/plain", charset);
        FileBody binFileBody = new FileBody(partFile);
        multipartEntityBuilder.addPart(partName, binFileBody);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            multipartEntityBuilder.addTextBody(entry.getKey(), entry.getValue(), contentType);
        }
        post.setEntity(multipartEntityBuilder.build());
        // 文件路径加入进去
        {
            params = new HashMap<>(params);
            params.put(partName, partFile.getAbsolutePath());
        }
        return exec(post, params, charset).getContent();
    }

    protected HttpResult exec(HttpUriRequest request, Object req, Charset charset) {
        CloseableHttpClient client = getHttpClient();

        HttpResult hr = new HttpResult();
        long beginTime = System.currentTimeMillis();// 开始时间
        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(request);
            if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                hr = new HttpResult(resp.getAllHeaders(), EntityUtils.toString(resp.getEntity(), charset));
            }
            StringBuilder builder = new StringBuilder(System.lineSeparator()).append("-----------------------------").append(System.lineSeparator()).append("请求地址：").append(request.getURI()).append(System.lineSeparator()).append("请求内容：").append(Objects.toString(req)).append(System.lineSeparator()).append("返回内容：").append(StringUtils.trimToEmpty(hr.getContent())).append(System.lineSeparator()).append("访问时长：").append((System.currentTimeMillis() - beginTime) + "ms").append(System.lineSeparator()).append("-----------------------------").append(System.lineSeparator());
            log.info(builder.toString());
        } catch (IOException e) {
            StringBuilder builder = new StringBuilder(System.lineSeparator()).append("-----------------------------").append(System.lineSeparator()).append("请求地址：").append(request.getURI()).append(System.lineSeparator()).append("请求内容：").append(Objects.toString(req)).append(System.lineSeparator()).append("异常信息：").append(e.getMessage()).append(System.lineSeparator()).append("访问时长：").append((System.currentTimeMillis() - beginTime) + "ms").append(System.lineSeparator()).append("-----------------------------").append(System.lineSeparator());
            log.error(builder.toString(), e);
        } finally {
            IOUtils.closeQuietly(resp);
        }
        return hr;
    }

    protected CloseableHttpResponse exec(HttpUriRequest request) {
        CloseableHttpClient client = getHttpClient();
        try {
            return client.execute(request);
        } catch (IOException e) {
            log.error("请求地址：" + request.getURI() + System.lineSeparator() + "，异常信息:" + e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


    protected void headers(HttpRequest request, Map<String, ?> headers) {
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, ? extends Object> entry : headers.entrySet()) {
                if (entry.getValue() != null) {
                    request.addHeader(entry.getKey(), Objects.toString(entry.getValue()));
                }
            }
        }
    }

    private String toLinkString(Map<String, String> params) {
        if (params.size() > 0) {
            List<String> parasStrings = new ArrayList<>(params.size());
            for (Map.Entry<String, String> entry : params.entrySet()) {
                parasStrings.add(toString(entry.getKey(), entry.getValue()));
            }
            return StringUtils.join(parasStrings, "&");
        }
        return "";
    }


    private String toString(String name, Object value) {
        return name + "=" + Objects.toString(value, "");
    }

}

package com.dwms.common.util.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient extends AbstractHttpClient implements Client {

    public HttpClient(int connectTimeout, int socketTimeout) {
        super(connectTimeout, socketTimeout);
    }

    @Override
    public CloseableHttpClient getHttpClient() {
        return HttpClients.custom()
                // 把请求相关的超时信息设置到连接客户端
                .setDefaultRequestConfig(getConfig())
                // 配置连接池管理对象
                .setConnectionManager(getCm()).setConnectionManagerShared(true).build();
    }
}

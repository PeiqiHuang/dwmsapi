package com.dwms.common.util.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

public class SSLHttpClient extends AbstractHttpClient implements Client {

    private String url;
    private String password;
    private String clientUrl;
    private String clientPassword;

    public SSLHttpClient(String url, String password) {
        this(url, password, null, null);
    }


    public SSLHttpClient(String url, String password, String clientUrl, String clientPassword) {
        this.url = url;
        this.password = password;
        this.clientUrl = clientUrl;
        this.clientPassword = clientPassword;
    }

    public SSLHttpClient(int connectTimeout, int socketTimeout, String url, String password) {
        this(connectTimeout, socketTimeout, url, password, null, null);
    }

    public SSLHttpClient(int connectTimeout, int socketTimeout, String url, String password, String clientUrl, String clientPassword) {
        super(connectTimeout, socketTimeout);
        this.url = url;
        this.password = password;
        this.clientUrl = clientUrl;
        this.clientPassword = clientPassword;
    }

    @Override
    public CloseableHttpClient getHttpClient() {
        return HttpClients.custom()
                // 把请求相关的超时信息设置到连接客户端
                .setDefaultRequestConfig(getConfig())
                // 配置连接池管理对象
                .setConnectionManager(getCm()).setConnectionManagerShared(true).build();
    }

    @Override
    protected SSLConnectionSocketFactory getSslConnectionSocketFactory() {
        SSLContext sslContext = null;
        try {
            SSLContextBuilder builder = SSLContexts.custom().loadTrustMaterial(new File(url), password.toCharArray());
            if (StringUtils.isNotEmpty(clientUrl) && StringUtils.isNotEmpty(clientPassword)) {
                InputStream in = new FileInputStream(new File(clientUrl));
                try {
                    KeyStore ks = getKeyStoreBySuffix(StringUtils.substringAfterLast(clientUrl, "."));
                    ks.load(in, clientPassword.toCharArray());
                    builder.loadKeyMaterial(ks, clientPassword.toCharArray());
                } finally {
                    in.close();
                }
            }
            sslContext = builder.build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException | CertificateException | IOException | UnrecoverableKeyException e) {
            log.error("init SSL connect error..", e);
            throw new RuntimeException(e);
        }

        return new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
    }

    private static KeyStore getKeyStoreBySuffix(String suffix) throws KeyStoreException {
        // pfx返回PKCS12
        if (StringUtils.equalsIgnoreCase("pfx", suffix)) {
            return KeyStore.getInstance("PKCS12");
        }
        // 默认
        return KeyStore.getInstance("JKS");
    }
}

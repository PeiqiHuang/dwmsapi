package com.dwms.common.util.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 请求的实例对象
 */
public abstract class HTTP {

    private static int connectTimeout = 3 * 1000;
    private static int socketTimeout = 20 * 1000;

    private static volatile Map<String, Client> map = new ConcurrentHashMap<>();
    private static Client defaultHttpClient = new HttpClient(connectTimeout, socketTimeout);

    public static Client getSSLHttpClient(String serverUrl, String serverPassword, String clientUrl, String clientPassword) {
        Client client = map.get(serverUrl);
        if (client == null) {
            synchronized (map) {
                client = map.get(serverUrl);
                if (client == null) {
                    client = new SSLHttpClient(connectTimeout, socketTimeout, serverUrl, serverPassword, clientUrl, clientPassword);
                    map.put(serverUrl, client);
                }
            }
        }
        return client;
    }

    public static Client getSSLHttpClient(String serverUrl, String serverPassword) {
        return getSSLHttpClient(serverUrl, serverPassword, null, null);
    }

    public static Client getDefaultHttpClient() {
        return defaultHttpClient;
    }
}

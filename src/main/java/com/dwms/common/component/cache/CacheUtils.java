package com.dwms.common.component.cache;

import org.springframework.cache.Cache;

/**
 * 缓存工具类
 * @author windy
 * @date 2016-12-20
 */
public class CacheUtils {

    /**
     * 获取缓存值
     * @author windy
     * @date 2017-04-18
     */
    public static <T> T get(String cacheName, String key, Class<T> clazz) {
        Cache cache = CacheConsts.CACHE.getCache(cacheName);
        if (cache != null) {
            return cache.get(key, clazz);
        }
        return null;
    }

    /**
     * 存储缓存值
     * @author windy
     * @date 2017-04-18
     */
    public static boolean put(String cacheName, String key, Object obj) {
        Cache cache = CacheConsts.CACHE.getCache(cacheName);
        if (cache == null) {
            return false;
        }
        cache.put(key, obj);
        return true;
    }

    /**
     * 清除缓存
     * @author windy
     * @date 2016-12-20
     */
    public static void evict(String cacheName, String key) {
        Cache cache = CacheConsts.CACHE.getCache(cacheName);
        if (cache != null) {
            cache.evict(key);
        }
    }

    /**
     * 清除所有缓存
     * @author windy
     * @date 2016-12-20
     */
    public static void evict(String cacheName) {
        Cache cache = CacheConsts.CACHE.getCache(cacheName);
        if (cache != null) {
            cache.clear();
        }
    }

    /**
     * 缓存是否存在
     * @author windy
     * @date 2016-12-27
     */
    public static boolean isExist(String cacheName, String key) {
        Cache cache = CacheConsts.CACHE.getCache(cacheName);
        if (cache != null) {
            return cache.get(key) != null;
        }
        return false;
    }
}
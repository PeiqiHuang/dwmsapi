package com.dwms.common.component.cache;

import com.dwms.common.util.SpringUtils;
import org.springframework.cache.CacheManager;

/**
 * 缓存常量类
 * @author windy
 * @date 2018-11-21
 */
public class CacheConsts {

    //缓存管理类
    public final static CacheManager CACHE = SpringUtils.getBean(CacheManager.class);

    //地区缓存
    public static final String DISTRICT = "dist";

    //AccessToken访问令牌缓存
    public static final String ACCESS_TOKEN = "accessToken";

    //验证码缓存
    public static final String SMS_CODE = "smsCode";

    //白名单缓存
    public static final String WHITE_IP = "whiteIP";

    //爬虫缓存
    public static final String CRAWLER = "crawler";

    //最近事务缓存
    public static final String MSG_MATTER = "msg_matter";

    //党建要闻缓存
    public static final String NEW_BUILD = "new_build";

}
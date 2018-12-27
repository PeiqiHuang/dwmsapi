package com.dwms.common.component.sms;

import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.consts.EnvEnum;
import com.dwms.common.consts.SysConsts;
import org.apache.commons.lang3.StringUtils;

import java.security.SecureRandom;

/**
 * 短信工具类
 * @author 罗俊标
 * @date 2016-12-12
 */
public class SmsUtils {

    /**
     * 生成验证码
     * @author 罗俊标
     * @date 2016-12-12
     */
    public static String generateSmsCode(int codeSize) {
        if (0 >= codeSize) {
            return null;
        }
        SecureRandom random = new SecureRandom();
        StringBuilder smsCodeBuf = new StringBuilder();
        for (int i = 0; i < codeSize; i++) {
            smsCodeBuf.append(SysConsts.DIGITALS.charAt(random.nextInt(10)));
        }
        return smsCodeBuf.toString();
    }

    /**
     * 验证验证码
     * @author windy
     * @date 2017-04-26
     */
    public static boolean verify(String mobile, String code) {
        //设置万能验证码
        if (EnvEnum.DEV.current()) {
            return true;
        }

        if (EnvEnum.TEST.current() && "6666".equals(code)) {
            return true;
        }


        // 获取缓存中的验证码
        String cacheCode = CacheUtils.get(CacheConsts.SMS_CODE, mobile, String.class);
        if (StringUtils.isBlank(cacheCode) || !cacheCode.equals(code)) {
            return false;
        }

        // 验证成功则清除缓存
        CacheUtils.evict(CacheConsts.SMS_CODE, mobile);
        return true;
    }
}
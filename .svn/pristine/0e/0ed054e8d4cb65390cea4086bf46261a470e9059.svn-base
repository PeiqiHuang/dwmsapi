package com.dwms.common.component.sms;

import com.alibaba.fastjson.JSONObject;
import com.dwms.common.util.HttpClientUtils;
import com.dwms.common.util.SignUtils;
import com.dwms.common.util.SpringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 联华信短信接口封装调用
 * @author 罗俊标
 * @date 2016-12-12
 */
public class WisentsoftSms {

    private static SmsConfig config = SpringUtils.getBean(SmsConfig.class);

    /**
     * 发送验证码
     * @author 罗俊标
     * @date 2016-12-12
     */
    public static boolean sendCode(String telphone, String code) {
        // 获取短信模板并替换验证码
        String smsTemplate = SmsConsts.TEMPLATE;
        String content = smsTemplate.replaceAll("#code", code);
        // 发送验证码，类型:verification
        return sendSms(telphone, content, "verification");
    }

    /**
     * 发送短信
     * @author 罗俊标
     * @date 2016-12-12
     */
    private static boolean sendSms(String telphone, String content, String invoker) {
        String urlStr = config.getUrl();
        Map<String, String> params = new HashMap<>();
        params.put("mobilePhone", telphone);
        params.put("msg", content);
        params.put("reqTime", String.valueOf(System.currentTimeMillis()));
        params.put("invoker", invoker);
        params.put("dpToken", config.getDpToken());
        String linkStr = SignUtils.paramToStr(params);
        params.put("dpSignture", SignUtils.signParam(linkStr, config.getSignKey()));

        String result = HttpClientUtils.post(urlStr, params);
        JSONObject json = JSONObject.parseObject(result);

        // 发送成功
        return "0".equals(json.getString("dpStatus"));
    }

}
package com.dwms.user.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import com.dwms.common.util.encrypt.AESUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户接口测试
 * @author windy
 * @date 2018-11-29
 */
@Profile("test")
public class UserAPI extends APITest {

    String appAES = "s4sdf3hozior55da";

    /**
     * 用户信息
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testGet() {
        String url = PREFIX + "/user/get.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 登录
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testLogin() {
        String url = PREFIX + "/user/login.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13533821400");//手机号码
        param.put("password", AESUtils.encrypt("123456", appAES));//密码

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 重设密码
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testReset() {
        String url = PREFIX + "/user/reset.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("mobile", "13533821404");//手机号码
        param.put("password", AESUtils.encrypt("a12345678", appAES));//密码
        param.put("smsCode", "6666");//密码

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 更新信息
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testUpd() {
        String url = PREFIX + "/user/upd.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("gender", "2");//性别 0未知 1男 2女

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}


package com.dwms.party.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 党支部接口测试
 * @author windy
 * @date 2018-12-02
 */
@Profile("dev")
public class PartyAPI extends APITest {

    /**
     * 党支部入驻申请
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testApply() {
        String url = PREFIX + "/party/apply.do";

        Map<String, String> param = new HashMap<String, String>();
        //        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("partyName", "深圳南山区党支部");//党支部名称
        param.put("memNum", "100");//党组织人数
        param.put("provCode", "440000");//省级代码
        param.put("cityCode", "440300");//市级代码
        param.put("distCode", "");//区县代码
        param.put("address", "南山区测试地址1号");//所在地址
        param.put("contract", "王大鸣");//联系人
        param.put("mobile", "13533212211");//联系电话
        param.put("email", "433235151@qq.com");//邮箱

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 党员列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    @Profile("dev")
    public void testUsers() {
        String url = PREFIX + "/party/users.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("partyId", "1");//党支部id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}

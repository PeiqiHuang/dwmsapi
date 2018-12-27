package com.dwms.msg.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 最近事务接口测试
 * @author windy
 * @date 2018-12-20
 */
@Profile("test")
public class MatterAPI extends APITest {

    /**
     * 待办事务
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testRecent() {
        String url = PREFIX + "/msg/matter/recent.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 最近事务
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testList() {
        String url = PREFIX + "/msg/matter/list.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}

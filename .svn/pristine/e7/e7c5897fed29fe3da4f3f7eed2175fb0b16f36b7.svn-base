package com.dwms.base.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试API接口
 * @author windy
 * @date 2018-11-22
 */
public class TestAPI extends APITest {

    /**
     * 测试列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testList() {
        String url = PREFIX + "/base/test/list.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("distDegree", "1");//级别(1:省，2:市，3:县)
        param.put("distType", "1");//地区类型(1:普通,2:直辖市,3:省直管)

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.get(url, param);
        System.out.println(result);
    }
}
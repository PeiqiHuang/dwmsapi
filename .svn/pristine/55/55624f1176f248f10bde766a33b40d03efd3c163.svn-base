package com.dwms.base.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共接口
 * @author windy
 * @date 2018-11-22
 */
@Profile("test")
public class CommonAPI extends APITest {

    /**
     * 测试列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testQrcode() {
        String url = PREFIX + "/common/qrcode.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("projName", "dwms");//项目名称
        param.put("busType", "meeting");//业务类型
        param.put("codeVal", "1");//代码值，如会议mtgId，1

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.get(url, param);
        System.out.println(result);
    }

    /**
     * 测试列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testDQrcode() {
        String url = PREFIX + "/common/dqrcode.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("QRCode", "chinapost://ZHdtcy9tZWV0aW5nLzE=");//代码值

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.get(url, param);
        System.out.println(result);
    }
}
package com.dwms.meeting.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 会议接口
 * @author windy
 * @date 2018-12-04
 */
@Profile("test")
public class MeetingAPI extends APITest {

    /**
     * 我的会议列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testMy() {
        String url = PREFIX + "/meeting/my.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("type", "1");//类型 -1已结束 1待参加

        //选填参数
//        param.put("pageNum", "1");//分页页码，不传查询全部
//        param.put("pageSize", "10");//分页显示数，不传查询全部

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 我的会议详情
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testMyDetail() {
        String url = PREFIX + "/meeting/myDetail.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("mtgId", "10");//会议id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 报名
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testApply() {
        String url = PREFIX + "/meeting/apply.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("mtgId", "10");//会议id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 请假
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testOff() {
        String url = PREFIX + "/meeting/off.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("mtgId", "17");//会议id
        param.put("offReason", "测试");//请假原因

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 签到
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testSignIn() {
        String url = PREFIX + "/meeting/signIn.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("signWay", "1");//签到方式 1自签（扫码） 2代签 3补签
        param.put("mtgId", "10");//会议id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }


}

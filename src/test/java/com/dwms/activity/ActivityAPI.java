package com.dwms.activity;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动接口测试
 * @author windy
 * @date 2018-12-06
 */
@Profile("dev")
public class ActivityAPI extends APITest {

    /**
     * 活动详情
     * @author windy
     * @date 2018-11-22
     */
    @Test
    @Profile("")
    public void testDetail() {
        String url = PREFIX + "/act/detail.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("actId", "1");//活动id

        //选填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 活动列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testList() {
        String url = PREFIX + "/act/list.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //选填参数
        //        param.put("status", "0");//状态 0待报名 1已报名
        param.put("pageNum", "1");//分页页码，不传查询全部
        param.put("pageSize", "10");//分页显示数，不传查询全部

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
        String url = PREFIX + "/act/apply.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("actId", "6");//活动id
        param.put("status", "1");//状态 0取消报名 1报名

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}

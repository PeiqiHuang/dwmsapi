package com.dwms.meeting.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 会议纪要测试
 * @author windy
 * @date 2018-12-04
 */
@Profile("test")
public class SummaryAPI extends APITest {

    /**
     * 纪要详情
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testDetail() {
        String url = PREFIX + "/meeting/summary/detail.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("sumId", "18");//纪要id
        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 相关纪要
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testRelation() {
        String url = PREFIX + "/meeting/summary/relation.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //选填参数
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
     * 发布纪要列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testRelease() {
        String url = PREFIX + "/meeting/summary/release.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //选填参数
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
     * 对应会议列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    @Profile("test")
    public void testRecorder() {
        String url = PREFIX + "/meeting/summary/recorder.do";

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
     * 保存纪要
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testSave() {
        String url = PREFIX + "/meeting/summary/save.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("mtgId", "13");//会议id
        param.put("sumTitle", "10月党支部会议2纪要2草稿");//纪要标题
        param.put("content", "10月党支部会议2纪要2草稿\r\ntest\r\netset");//纪要内容
        param.put("status", "0");//状态 0待发布 1发布

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 修改纪要
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testUpd() {
        String url = PREFIX + "/meeting/summary/upd.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("sumId", "13");//纪要id
        param.put("sumTitle", "10月党支部会议2纪要2草稿");//纪要标题
        param.put("content", "10月党支部会议2纪要2草稿");//纪要内容
        param.put("status", "1");//状态 0待发布 1发布

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 删除纪要
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testDel() {
        String url = PREFIX + "/meeting/summary/del.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("sumId", "13");//纪要id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 删除纪要
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testRead() {
        String url = PREFIX + "/meeting/summary/read.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("sumId", "11");//纪要id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

}

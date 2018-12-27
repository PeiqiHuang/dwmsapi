package com.dwms.examine.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 考试测试
 * @author windy
 * @date 2018-12-17
 */
@Profile("dev")
public class ExamineAPI extends APITest {

    /**
     * 考试详情
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testDetail() {
        String url = PREFIX + "/examine/detail.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("euId", "6");//考试id

        //选填参数

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 考试列表
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testList() {
        String url = PREFIX + "/examine/list.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "3564a104360e4e349120543482d773ad");//用户userId

        //选填参数
        //        param.put("status", "0");//状态 -1待考 0已考
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
     * 考试答案
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testAnswer() {
        String url = PREFIX + "/examine/answer.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("euId", "34");//考试id

        //选填参数
        //        param.put("chapterType", "1");//章节类型 1章 2节

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 答题
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testSave() {
        String url = PREFIX + "/examine/save.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "3564a104360e4e349120543482d773ad");//用户userId
        param.put("euId", "31");//考试id
        param.put("timeLength", "24");//考试用时（秒）

        //选填参数
        param.put("answers[0].eqId", "24");//考试题目id
        param.put("answers[0].answer", "B");//回答答案（多选题、多个空的填空题答案分号分隔 A.aaa;B.bbb;...）
        param.put("answers[1].eqId", "25");//回答答案（多选题、多个空的填空题答案分号分隔 A.aaa;B.bbb;...）
        param.put("answers[1].answer", "A===B");//回答答案（多选题、多个空的填空题答案分号分隔 A.aaa;B.bbb;...）
        param.put("answers[3].eqId", "27");//回答答案（多选题、多个空的填空题答案分号分隔 A.aaa;B.bbb;...）
        param.put("answers[3].answer", "A===B===C===D");//回答答案（多选题、多个空的填空题答案分号分隔 A.aaa;B.bbb;...）

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}

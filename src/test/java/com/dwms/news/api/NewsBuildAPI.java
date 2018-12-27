package com.dwms.news.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 党建要闻接口测试
 * @author windy
 * @date 2018-12-06
 */
@Profile("dev")
public class NewsBuildAPI extends APITest {

    /**
     * 要闻列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testList() {
        String url = PREFIX + "/news/build/list.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("keyword", "gcdyyt");//关键字,活动gcdyhd,讲话gcdyjh,特稿gcdytg,微视gcdyws,研讨gcdyyt

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
}

package com.dwms.notice.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 通知公告接口测试
 * @author windy
 * @date 2018-12-06
 */
@Profile("dev")
public class NoticeAPI extends APITest {

    /**
     * 公告列表
     * @author windy
     * @date 2018-11-22
     */
    @Test
    public void testList() {
        String url = PREFIX + "/notice/list.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("partyId", "1");//党支部id

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

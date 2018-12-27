package com.dwms.help;

import com.dwms.APITest;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;


@Profile("dev")
public class HelpAPI extends APITest {

    /**
     * 获取帮助信息列表
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testHelpList() {
        String url = PREFIX + "/help/list.do";

        Map<String, String> param = new HashMap<String, String>();
        commonResult(param, url);
    }

    /**
     * 获取帮助信息详情
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testHelpDetail() {
        String url = PREFIX + "/help/detail.do";

        Map<String, String> param = new HashMap<String, String>();
        param.put("infoId", "1");

        commonResult(param, url);
    }
}

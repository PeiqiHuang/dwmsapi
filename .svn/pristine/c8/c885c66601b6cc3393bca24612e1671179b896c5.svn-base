package com.dwms.advice;

import com.dwms.APITest;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;


@Profile("dev")
public class AdviceAPI extends APITest {

    /**
     * 添加反馈
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testWish() {
        String url = PREFIX + "/advice/add.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("adviceText", "我要反馈");//反馈内容

        commonResult(param, url);
    }

}

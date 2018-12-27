package com.dwms.due.api;

import com.dwms.APITest;
import com.dwms.common.util.HttpClientUtils;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * 党费接口测试
 * @author windy
 * @date 2018-12-07
 */
@Profile("dev")
public class DueAPI extends APITest {

    /**
     * 党费详情
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testDetail() {
        String url = PREFIX + "/due/detail.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "473c399ab9b54d04a1eda8911fa85ca5");//用户userId
        param.put("dueId", "4");//党费id

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }

    /**
     * 党费列表
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testList() {
        String url = PREFIX + "/due/list.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId

        //选填参数
        param.put("status", "0");//缴费状态 0未缴费 1已缴费
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
     * 确认缴费
     * @author windy
     * @date 2018-12-07
     */
    @Test
    public void testConfirm() {
        String url = PREFIX + "/due/confirm.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("dueId", "6");//党费id
        param.put("due", "80");//缴费金额，目前只需传整，如1元传1
        param.put("payWay", "1");//缴费方式 1微信 2银行卡转账 3支付宝 4现金支付
        //        param.put("imgPath", "50fccd1b4354451b9a8ac913ea09fee3");//上传缴费凭证

        //签名
        param = defaultSign(param);

        System.out.println("访问服务:" + url);
        System.out.println("访问地址:" + url + "?" + paramStr(param));
        String result = HttpClientUtils.post(url, param);
        System.out.println(result);
    }
}

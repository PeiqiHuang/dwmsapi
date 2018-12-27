package com.dwms.birthday;

import com.dwms.APITest;
import org.junit.Test;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;


@Profile("dev")
public class BirthdayAPI extends APITest {

    /**
     * 送祝福
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testWish() {
        String url = PREFIX + "/birth/wish.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("userId", "50fccd1b4354451b9a8ac913ea09fee3");//用户userId
        param.put("toUserId", "50fccd1b4354451b9a8ac913ea09fee3");//被祝福人用户编号
        param.put("wishType", "2");//祝福类型
        param.put("wishText", "祝你生日快乐");//用户userId

        commonResult(param, url);
    }

    /**
     * 获取祝福模板
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testWishTemp() {
        String url = PREFIX + "/birth/wishTemp.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("partyId", "1");//党支部id

        commonResult(param, url);
    }

    /**
     * 获取最近政治生日
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testRecentBirth() {
        String url = PREFIX + "/birth/recentBirth.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("partyId", "1");//党支部id

        //选填参数
        param.put("pageNum", "1");//分页页码，不传查询全部
        param.put("pageSize", "10");//分页显示数，不传查询全部

        commonResult(param, url);
    }

    /**
     * 获取祝福列表
     * @author yunbin
     * @date 2018-12-13
     */
    @Test
    public void testWishList() {
        String url = PREFIX + "/birth/wishList.do";

        Map<String, String> param = new HashMap<String, String>();
        //必填参数
        param.put("toUserId", "506d7321c0b547538f93010945169345");//党支部id

        //选填参数
        param.put("wishType", "1");

        param.put("pageNum", "1");//分页页码，不传查询全部
        param.put("pageSize", "10");//分页显示数，不传查询全部

        commonResult(param, url);
    }
}

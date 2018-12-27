package com.dwms.party.dao;

import com.dwms.BaseTest;
import com.dwms.party.model.bean.PartyApply;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author windy
 * @date 2018-12-03
 */
public class PartyDAOTest extends BaseTest {

    @Resource
    private IPartyApplyDAO partyApplyDAO;

    /**
     * 保存申请
     * @author windy
     * @date 2018-12-03
     */
    @Test
    public void testInsertApply() {
        PartyApply a = new PartyApply();
        a.setPartyName("深圳南山区党支部");//党支部名称
        a.setMemNum(100);//党组织人数
        a.setProvCode("440000");//省级代码
        a.setCityCode("440300");//市级代码
        a.setDistCode("");//区县代码
        a.setAddress("南山区测试地址1号");//所在地址
        a.setContract("王大鸣");//联系人
        a.setMobile("13533212211");//联系电话
        a.setEmail("433235151@qq.com");//邮箱
        a.setStatus(0);
        a.setCreateTime(null);
        partyApplyDAO.insert(a);
    }


}

package com.dwms.test.dao;

import com.alibaba.fastjson.JSON;
import com.dwms.BaseTest;
import com.dwms.test.model.bean.TestTime;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author windy
 * @date 2018-12-03
 */
public class TestTimeDAOTest extends BaseTest {

    @Resource
    private ITestTimeDAO testTimeDAO;

    @Test
    public void testInsert() {
        TestTime t = new TestTime();
        t.setName("test");
        testTimeDAO.insertSelective(t);

        List<TestTime> ts = testTimeDAO.selectAll();
        System.out.println(JSON.toJSONString(ts));
    }
}

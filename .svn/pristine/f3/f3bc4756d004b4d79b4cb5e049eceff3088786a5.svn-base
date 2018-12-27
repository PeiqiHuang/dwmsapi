package com.dwms.user.dao;

import com.dwms.BaseTest;
import com.dwms.common.util.UUIDUtils;
import com.dwms.user.model.bean.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author windy
 * @date 2018-11-27
 */
public class UserDAOTest extends BaseTest {

    @Resource
    private IUserDAO userDAO;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserId(UUIDUtils.generateUUID());
        user.setUserName("test");
        System.out.println(userDAO.insert(user));


    }
}

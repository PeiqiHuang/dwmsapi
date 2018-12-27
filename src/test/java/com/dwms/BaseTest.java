package com.dwms;

import com.dwms.common.config.SysConfig;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 基本测试
 * @author windy
 * @date 2018-11-21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public abstract class BaseTest {

    @Resource
    private SysConfig sysConfig;

    @Before
    public void info() {
        System.out.println("当前启动环境：" + sysConfig.getEnv());
    }

    /**
     * 设置环境变量，用于加载资源文件，否则只会以maven的profiles的id为准
     * TODO:待修改，目前还没有加载maven的非profiles的id下的资源
     * @author windy
     * @date 2018-11-21
     */
    @BeforeClass
    public static void env() {
        ActiveProfiles annotation = (ActiveProfiles) BaseTest.class.getAnnotation(ActiveProfiles.class);
        System.setProperty("spring.profiles.active", annotation.value()[0]);
    }
}

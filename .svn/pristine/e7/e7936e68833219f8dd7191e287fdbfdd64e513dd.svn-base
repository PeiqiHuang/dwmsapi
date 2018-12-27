package com.dwms.base.service;

import com.dwms.base.model.bean.District;
import com.dwms.base.model.form.DistListForm;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;
import org.springframework.scheduling.annotation.Async;

import java.util.Map;

/**
 * 测试服务
 * @author windy
 * @date 2018-11-19
 */
public interface ITestService {

    /**
     * 查询地区
     * @author windy
     * @date 2018-11-20
     */
    ResultBean get(String distCode);

    /**
     * 测试thymeleaf页面
     * @author windy
     * @date 2018-11-19
     */
    Map<String, Object> index(Page<District> page);

    /**
     * 测试json接口
     * @author windy
     * @date 2018-11-19
     */
    ResultBean list(Page<District> page, DistListForm form);

    /**
     * 保存
     * @author windy
     * @date 2018-11-21
     */
    ResultBean save();

    /**
     * 缓存校验
     * @author windy
     * @date 2018-11-21
     */
    ResultBean ehcache(Page<District> page);

    /**
     * 异步异常
     * @author windy
     * @date 2018-11-21
     */
    @Async
    ResultBean async(String num);
}

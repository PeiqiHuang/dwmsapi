package com.dwms.base.service.impl;

import com.alibaba.fastjson.JSON;
import com.dwms.base.dao.IAccessTokenDAO;
import com.dwms.base.dao.IDistDAO;
import com.dwms.base.model.bean.AccessToken;
import com.dwms.base.model.bean.District;
import com.dwms.base.model.form.DistListForm;
import com.dwms.base.service.ITestService;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


/**
 * 测试Service
 * @author windy
 * @date 2018-11-19
 */
@Service
public class TestService implements ITestService {

    private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

    @Resource
    private IDistDAO distDAO;
    @Resource
    private IAccessTokenDAO accessTokenDAO;

    @Override
    public ResultBean get(String distCode) {
        District dist = distDAO.selectByPrimaryKey(distCode);
        Map<String, Object> data = Maps.newHashMap();
        data.put("dist", dist);
        return ResultUtils.successBean(data);
    }

    @Override
    public Map<String, Object> index(Page<District> page) {
        //Lambda写法
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize()).doSelectPage(() -> distDAO.selectAll());
        return PageUtils.map(page);
    }

    @Override
    public ResultBean list(Page<District> page, DistListForm form) {
        //count表示是否进行统计语句查询
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        //当pageSize为0时，表示查询所有数据
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> distDAO.selectSelective(form));
        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean save() {
        AccessToken token = accessTokenDAO.selectByPrimaryKey("dwms_test");
        System.out.println(JSON.toJSONString(token));

        District dist = new District();
        dist.setDistCode("000000");
        dist.setDistName("全国");
        dist.setDistStatus(1);
        distDAO.insert(dist);
        Integer.parseInt("as");
        return ResultUtils.successBean();
    }

    @Override
    public ResultBean ehcache(Page<District> page) {
        String key = page.getPageNum() + "_" + page.getPageSize();
        Page<District> result = CacheUtils.get(CacheConsts.DISTRICT, key, Page.class);
        if (result == null || result.isEmpty()) {
            System.out.println("不走缓存");
            boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
            result = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> distDAO.selectAll());
            CacheUtils.put(CacheConsts.DISTRICT, key, result);
        }
        return ResultUtils.successBean(PageUtils.map(result));
    }

    @Override
    @Async
    public ResultBean async(String num) {
        LOG.info("async start:" + num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer.parseInt(num);
        LOG.info("async end:" + num);
        return ResultUtils.successBean();
    }

}

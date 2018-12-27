package com.dwms.crawler.mgr.impl;

import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.crawler.dao.ICrawlerTaskDAO;
import com.dwms.crawler.mgr.ICrawlerMgr;
import com.dwms.crawler.model.bean.CrawlerTask;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 爬虫通用层
 * @author windy
 * @date 2018-12-11
 */
@Repository
public class CrawlerMgr implements ICrawlerMgr {

    @Resource
    private ICrawlerTaskDAO crawlerTaskDAO;

    @Override
    public CrawlerTask selectByRequestUrl(String requestUrl) {
        CrawlerTask ct = CacheUtils.get(CacheConsts.CRAWLER, requestUrl, CrawlerTask.class);
        if (ct == null) {
            ct = crawlerTaskDAO.selectByRequestUrl(requestUrl);
            CacheUtils.put(CacheConsts.CRAWLER, requestUrl, ct);
        }
        return ct;
    }
}

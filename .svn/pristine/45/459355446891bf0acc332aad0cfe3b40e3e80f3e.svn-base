package com.dwms.crawler.service.impl;

import com.dwms.common.model.ResultBean;
import com.dwms.common.util.ResultUtils;
import com.dwms.crawler.dao.ICrawlerTaskDAO;
import com.dwms.crawler.model.bean.CrawlerTask;
import com.dwms.crawler.processor.GongChangProcessor;
import com.dwms.crawler.service.ICrawlerService;
import com.dwms.crawler.service.IGongChangService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.List;

/**
 * 爬虫服务
 * @author windy
 * @date 2018-12-11
 */
@Service
public class CrawerService implements ICrawlerService {

    @Resource
    private ICrawlerTaskDAO crawlerTaskDAO;
    @Resource
    private GongChangProcessor gongChangProcessor;
    @Resource
    private IGongChangService gongChangService;

    @Override
    public ResultBean gongChang() {
        String domainName = "http://www.12371.cn";
        List<CrawlerTask> cs = crawlerTaskDAO.selectLikeRequestUrl(domainName);
        if (CollectionUtils.isEmpty(cs)) {
            return null;
        }

        String[] urls = new String[cs.size()];
        int i = 0;
        for (CrawlerTask c : cs) {
            urls[i++] = c.getRequestUrl();
        }

        Spider.create(gongChangProcessor).addUrl(urls).addPipeline(gongChangService).thread(20).run();
        return ResultUtils.successBean();
    }
}

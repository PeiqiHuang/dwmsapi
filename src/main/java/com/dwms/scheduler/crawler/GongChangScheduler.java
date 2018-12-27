package com.dwms.scheduler.crawler;

import com.dwms.crawler.service.ICrawlerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 共产党员网定时器
 * @author windy
 * @date 2018-12-12
 */
@Component
public class GongChangScheduler {

    @Resource
    private ICrawlerService crawlerService;

    /**
     * 定时爬取
     * @author windy
     * @date 2018-12-12
     */
    //    @Scheduled(cron = "0 0 0,2,4 * * ?")
    @Scheduled(fixedDelay = 6000L * 3600)
    public void crawler() {
        crawlerService.gongChang();
    }
}

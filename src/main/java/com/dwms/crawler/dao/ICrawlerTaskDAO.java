package com.dwms.crawler.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.crawler.model.bean.CrawlerTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 爬虫任务DAO接口
 * @author windy
 * @date 2018-12-11
 */
public interface ICrawlerTaskDAO extends BaseMapper<CrawlerTask> {

    /**
     * 爬虫任务
     * @author windy
     * @date 2018-12-11
     */
    CrawlerTask selectByRequestUrl(@Param("requestUrl") String requestUrl);

    /**
     * 爬虫任务列表
     * @author windy
     * @date 2018-12-11
     */
    List<CrawlerTask> selectLikeRequestUrl(@Param("requestUrl") String requestUrl);

}

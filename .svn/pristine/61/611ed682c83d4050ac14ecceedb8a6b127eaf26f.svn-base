package com.dwms.crawler.dao;

import com.dwms.common.mapper.BaseMapper;
import com.dwms.crawler.model.bean.CrawlerHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 爬虫历史DAO接口
 * @author windy
 * @date 2018-12-11
 */
public interface ICrawlerHistoryDAO extends BaseMapper<CrawlerHistory> {

    /**
     * 爬虫历史列表
     * @author windy
     * @date 2018-12-11
     */
    CrawlerHistory selectByRequestUrl(@Param("requestUrl") String requestUrls);

    /**
     * 爬虫历史列表
     * @author windy
     * @date 2018-12-11
     */
    List<CrawlerHistory> selectByRequestUrls(@Param("requestUrls") List<String> requestUrls);

    /**
     * 爬虫历史列表
     * @author windy
     * @date 2018-12-11
     */
    List<String> selectBySourceUrl(@Param("sourceUrl") String sourceUrl);

}

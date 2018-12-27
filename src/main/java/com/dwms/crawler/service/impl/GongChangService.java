package com.dwms.crawler.service.impl;


import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.config.ImageConfig;
import com.dwms.common.config.SysConfig;
import com.dwms.common.util.DateUtils;
import com.dwms.common.util.FileUtils;
import com.dwms.common.util.HtmlContentUtils;
import com.dwms.crawler.consts.CrawlerConsts;
import com.dwms.crawler.dao.ICrawlerHistoryDAO;
import com.dwms.crawler.mgr.ICrawlerMgr;
import com.dwms.crawler.model.bean.CrawlerHistory;
import com.dwms.crawler.model.bean.CrawlerTask;
import com.dwms.crawler.service.IGongChangService;
import com.dwms.news.consts.NewsBuildConsts;
import com.dwms.news.dao.INewsBuildDAO;
import com.dwms.news.model.bean.NewsBuild;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 共产党员网服务
 * @author windy
 * @date 2018-12-11
 */
@Repository
public class GongChangService implements IGongChangService {

    //添加头部信息
    private final static String META = "<!DOCTYPE html><html lang=\"zh-cn\"><head><meta name=\"viewport\" content=\"width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\"><meta charset=\"UTF-8\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/><style type=\"text/css\">div img {max-width: 100%;height: auto;}</style></head><body>";
    @Resource
    private ICrawlerHistoryDAO crawlerHistoryDAO;
    @Resource
    private INewsBuildDAO newsBuildDAO;
    @Resource
    private ICrawlerMgr crawlerMgr;
    @Resource
    private SysConfig sysConfig;
    @Resource
    private ImageConfig imageConfig;

    @Override
    public void process(ResultItems items, Task task) {
        //内容检查
        String requestUrl = items.get("requestUrl");
        String bigTitle = items.get("bigTitle");//大标题
        String content = items.get("content");//正文内容
        Date releaseTime = items.get("releaseTime");//发布日期
        String image = items.get("image");//封面图片
        String parentUrl = CacheUtils.get(CacheConsts.CRAWLER, requestUrl + "_parentUrl", String.class);//上级url
        CrawlerTask ct = crawlerMgr.selectByRequestUrl(parentUrl);

        CrawlerHistory ch = crawlerHistoryDAO.selectByRequestUrl(requestUrl);
        //爬虫失败
        if (StringUtils.isAnyBlank(requestUrl, bigTitle, content)) {
            if (StringUtils.isNotBlank(requestUrl)) {
                //保存爬虫历史
                if (ch == null) {
                    ch = new CrawlerHistory();
                    ch.setCtId(ct.getCtId());
                    ch.setRequestUrl(requestUrl);
                    ch.setSourceUrl(parentUrl);
                    ch.setTimes(1);
                    ch.setStatus(CrawlerConsts.STATUS_FAIL);
                    crawlerHistoryDAO.insertSelective(ch);
                } else {
                    ch.setTimes(ch.getTimes() + 1);
                    ch.setStatus(CrawlerConsts.STATUS_FAIL);
                    crawlerHistoryDAO.updateByPrimaryKeySelective(ch);
                }
            }
            return;
        }


        String newTitle = META + "<h1>" + bigTitle + "</h1><i>" + ct.getSiteName() + "    " + StringUtils.defaultString(DateUtils.formatDate(releaseTime, "yyyy年MM月dd日")) + "</i>";
        content = newTitle + content + "</body>";

        //保存党建要闻
        NewsBuild nb = new NewsBuild();
        nb.setTitle(CacheUtils.get(CacheConsts.CRAWLER, requestUrl, String.class));
        nb.setCover(image);
        nb.setSource(ct.getSiteName());
        nb.setSourceType(NewsBuildConsts.SOURCETYPE_CRAWLER);
        nb.setSourceUrl(requestUrl);
        nb.setStatus(NewsBuildConsts.STATUS_OPEN);
        nb.setReleaseTime(releaseTime);
        nb.setKeyword(ct.getKeyword());
        newsBuildDAO.insertSelective(nb);

        //保存文件
        String fileName = nb.getNbId() + ".html";
        String filePath = sysConfig.getHtmlRoot() + imageConfig.getNewsBuild() + "/" + fileName;
        String basePath = sysConfig.getUploadPath() + sysConfig.getHtmlRoot() + imageConfig.getNewsBuild() + "/";

        content = HtmlContentUtils.html(content);
        boolean ok = FileUtils.save(content, basePath, fileName);
        if (!ok) {
            //保存爬虫历史
            if (ch == null) {
                ch = new CrawlerHistory();
                ch.setCtId(ct.getCtId());
                ch.setRequestUrl(requestUrl);
                ch.setSourceUrl(parentUrl);
                ch.setTimes(1);
                ch.setStatus(CrawlerConsts.STATUS_FAIL);
                crawlerHistoryDAO.insertSelective(ch);
            } else {
                ch.setTimes(ch.getTimes() + 1);
                ch.setStatus(CrawlerConsts.STATUS_FAIL);
                crawlerHistoryDAO.updateByPrimaryKeySelective(ch);
            }
            newsBuildDAO.deleteByPrimaryKey(nb.getNbId());
            return;
        }
        nb.setFilePath(filePath);
        newsBuildDAO.updateByPrimaryKeySelective(nb);

        //保存爬虫历史
        if (ch == null) {
            ch = new CrawlerHistory();
            ch.setCtId(ct.getCtId());
            ch.setRequestUrl(requestUrl);
            ch.setFilePath(filePath);
            ch.setSourceUrl(parentUrl);
            ch.setTimes(1);
            ch.setStatus(CrawlerConsts.STATUS_SUCCESS);
            crawlerHistoryDAO.insertSelective(ch);
        } else {
            ch.setFilePath(filePath);
            ch.setTimes(ch.getTimes() + 1);
            ch.setStatus(CrawlerConsts.STATUS_SUCCESS);
            crawlerHistoryDAO.updateByPrimaryKeySelective(ch);
        }
    }
}

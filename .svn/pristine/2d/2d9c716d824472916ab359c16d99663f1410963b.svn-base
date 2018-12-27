package com.dwms.crawler.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.consts.SysConsts;
import com.dwms.common.util.DateUtils;
import com.dwms.common.util.HtmlContentUtils;
import com.dwms.crawler.consts.GongchangConsts;
import com.dwms.crawler.dao.ICrawlerHistoryDAO;
import com.dwms.crawler.mgr.ICrawlerMgr;
import com.dwms.crawler.model.bean.CrawlerTask;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 共产党员网Processor
 * @author windy
 * @date 2018-12-11
 */
@Component
public class GongChangProcessor implements PageProcessor {

    private static final String THUMB_REGEX = "\\[\\{'link_add'(.*)'\\}\\]";//百度保存图片url正则
    private static final Pattern THUMB_PATTERN = Pattern.compile(THUMB_REGEX);
    @Resource
    private ICrawlerHistoryDAO crawlerHistoryDAO;
    @Resource
    private ICrawlerMgr crawlerMgr;

    @Override
    public void process(Page page) {
        if (page.getUrl().get().contains("special")) {
            //列表页面
            String url = page.getUrl().get();

            CrawlerTask task = crawlerMgr.selectByRequestUrl(url);
            if (task == null) {
                throw new RuntimeException("不需要爬虫" + url);
            }

            switch (task.getKeyword()) {
                //活动，讲话
                case GongchangConsts.GCDYHD:
                case GongchangConsts.GCDYJH:
                    showMoreNChildren(page, task);
                    break;
                //特稿，微视，研讨
                case GongchangConsts.GCDYTG:
                case GongchangConsts.GCDYWS:
                case GongchangConsts.GCDYYT:
                    columnWrapperJson(page, task);
                    break;
                default:
                    break;
            }
        } else {
            //详情页面
            Html html = page.getHtml();
            String requestUrl = page.getUrl().get();
            String bigTitle = "//h1[@class=big_title]/text()";//大标题
            String content = "//div[@id=font_area]";//正文内容
            String publishTime = "//div[@class=title_mobile_bottom]/i[@class=time]/text()";//发布时间
            String image = "//div[@id=font_area]//img[1]/@src";
            bigTitle = html.xpath(bigTitle).get();
            content = html.xpath(content).get();
            publishTime = html.xpath(publishTime).get();
            String cacheImage = CacheUtils.get(CacheConsts.CRAWLER, requestUrl + "_image", String.class);
            if (StringUtils.isBlank(cacheImage)) {
                image = html.xpath(image).get();
            } else {
                image = cacheImage;
            }

            content = HtmlContentUtils.htmlComment(content).replace("\r\n", "").replace("\n", "").replace("  ", "");
            Date releaseTime = null;
            if (StringUtils.isNotBlank(publishTime)) {
                publishTime = publishTime.substring(5, 22);
                releaseTime = DateUtils.strToDate(publishTime, "yyyy年MM月dd日 HH:mm");
            }

            page.putField("requestUrl", requestUrl);
            page.putField("bigTitle", bigTitle);
            page.putField("content", content);
            page.putField("releaseTime", releaseTime);
            page.putField("image", image);
        }
    }

    @Override
    public Site getSite() {
        // 抓取网站的相关配置，可以包括编码、抓取间隔1s、重试次数等
        return Site.me().setCharset(SysConsts.CHARSET).setRetryTimes(100).setSleepTime(1000);
    }

    /**
     * 抓取页面列表元素
     * @author windy
     * @date 2018-12-18
     */
    private Page showMoreNChildren(Page page, CrawlerTask task) {
        String url = page.getUrl().get();
        String baseXPath = task.getXpath();
        List<Selectable> selectables = page.getHtml().xpath(baseXPath).nodes();
        if (selectables.isEmpty()) {
            throw new RuntimeException();
        }

        //分析页面
        List<String> urls = Lists.newArrayList();
        for (Selectable s : selectables) {
            String title = s.xpath("//a/text()").get();//标题
            String requestUrl = s.xpath("//a/@href").get();//详情链接
            urls.add(requestUrl);
            //保存链接内容进缓存
            CacheUtils.put(CacheConsts.CRAWLER, requestUrl, title);
            CacheUtils.put(CacheConsts.CRAWLER, requestUrl + "_parentUrl", url);
        }

        //详情页面爬取链接
        List<String> chs = crawlerHistoryDAO.selectBySourceUrl(url);
        urls.removeAll(chs);
        if (CollectionUtils.isEmpty(urls)) {
            throw new RuntimeException("不需要爬虫" + url);
        }

        page.addTargetRequests(urls);
        return page;
    }

    /**
     * 抓取页面script的json元素
     * @author windy
     * @date 2018-12-18
     */
    private Page columnWrapperJson(Page page, CrawlerTask task) {
        String url = page.getUrl().get();
        String baseXPath = task.getXpath();
        Selectable s = page.getHtml().xpath(baseXPath).nodes().get(0);
        if (s == null || s.get() == null || "".equals(s.get())) {
            throw new RuntimeException();
        }

        JSONArray infos = columnWrapperArray(s.get());
        List<String> urls = Lists.newArrayList();
        for (int i = 0; i < infos.size(); i++) {
            String title = infos.getJSONObject(i).getString("title");//标题
            String requestUrl = infos.getJSONObject(i).getString("link_add");//详情链接
            urls.add(requestUrl);
            //保存链接内容进缓存
            if (StringUtils.isNotBlank(title)) {
                if (title.contains("<BR>")) {
                    title = title.substring(0, title.indexOf("<BR>"));
                }
                if (title.startsWith("<a href=")) {
                    int startIndex = title.indexOf(">") + 1;
                    int lastIndex = title.indexOf("<br>");
                    title = title.substring(startIndex, lastIndex);
                }
            }
            CacheUtils.put(CacheConsts.CRAWLER, requestUrl, title);
            CacheUtils.put(CacheConsts.CRAWLER, requestUrl + "_parentUrl", url);
            if (GongchangConsts.GCDYWS.equals(task.getKeyword())) {
                String image = infos.getJSONObject(i).getString("image");
                if (StringUtils.isNotBlank(image)) {
                    CacheUtils.put(CacheConsts.CRAWLER, requestUrl + "_image", image);
                }
            }
        }

        //详情页面爬取链接
        List<String> chs = crawlerHistoryDAO.selectBySourceUrl(url);
        urls.removeAll(chs);
        if (CollectionUtils.isEmpty(urls)) {
            throw new RuntimeException("不需要爬虫" + url);
        }
        page.addTargetRequests(urls);
        return page;
    }

    /**
     * 获取json字符串
     * @author windy
     * @date 2018-12-18
     */
    private JSONArray columnWrapperArray(String str) {
        if (StringUtils.isBlank(str)) {
            return new JSONArray();
        }

        Matcher matcher = THUMB_PATTERN.matcher(str);
        if (matcher.find()) {
            return JSON.parseArray(matcher.group());
        }

        return new JSONArray();
    }

    public static void main(String[] args) {
        GongChangProcessor processor = new GongChangProcessor();
        Spider.create(processor).addUrl("http://syss.12371.cn/2015/09/09/ARTI1441792255993728.shtml").thread(1).run();
    }


}
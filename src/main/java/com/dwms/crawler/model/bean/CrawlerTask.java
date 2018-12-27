package com.dwms.crawler.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 爬虫任务
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_crawler_task")
public class CrawlerTask implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ctId;//逻辑id

    private String name;//爬虫任务名称
    private String keyword;//关键字标志
    private String siteName;//网站名称
    private String requestUrl;//爬虫链接
    private String templatePath;//内容替换模板
    private Integer status;//状态 0禁用 1启用
    private String sysUserId;//修改管理员id
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
    private String xpath;//xpath内容表达式
    private Integer type;//爬取方式 1html页面元素 2htmljson数据 3接口json数据
}

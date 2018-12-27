package com.dwms.crawler.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 爬虫历史
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_crawler_history")
public class CrawlerHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chId;//逻辑id

    private Integer ctId;//爬虫任务id
    private String requestUrl;//爬虫访问链接
    private String filePath;//保存文件地址
    private String sourceUrl;//爬虫上级url，多来源于爬虫任务表的requestUrl
    private Integer times;//爬取次数
    private Integer status;//状态 -1禁用 0失败 1成功
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
}

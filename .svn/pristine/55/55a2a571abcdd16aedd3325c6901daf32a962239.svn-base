package com.dwms.news.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党建要闻
 * @author windy
 * @date 2018-12-11
 */
@Data
@Table(name = "tb_news_build")
public class NewsBuild implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nbId;//要闻id

    private String title;//标题
    private String cover;//封面
    private String source;//来源
    private Integer sourceType;//来源途径 0手工 1爬虫
    private String sourceUrl;//来源url
    private String keyword;//来源种类
    private String filePath;//保存文件地址
    private Integer status;//状态 0禁用 1启用
    private Date releaseTime;//发布时间
    private Date updateTime;//修改时间
    private Date createTime;//创建时间

}

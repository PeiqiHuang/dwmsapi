package com.dwms.base.model.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告
 * @author windy
 * @date 2018-11-23
 */
@ApiModel(value = "广告对象")
@Data
@Table(name = "tb_advert_info")
public class Advert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adId;//广告id

    @ApiModelProperty(notes = "广告名称", value = "广告名称", example = "http://localhost:8080/dwmsres/image/1.jpg")
    private String name;//广告名称
    private String action;//动作
    private String summary;//简介
    private Integer weight;//权重，0-10，默认0，越大表示越前
    private String adkey;//广告位置key
    private Date begintime;//广告开始时间
    private Date endtime;//广告结束时间
    private Integer status;//状态 0禁用 1启用
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}

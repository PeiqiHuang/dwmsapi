package com.dwms.activity.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动信息
 * @author windy
 * @date 2018-12-05
 */
@Data
@Table(name = "tb_activity_info")
public class Activity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actId;//活动id

    private Integer partyId;//党支部ID
    private String actName;//活动名称
    private String actDesc;//活动详情
    private String address;//活动地址
    private String filePath;//活动文件地址
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date beginTime;//活动开始时间
    private Date endTime;//活动结束时间
    private Date applyEndTime;//报名截止时间
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
}

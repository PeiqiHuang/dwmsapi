package com.dwms.notice.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 通知公告
 * @author windy
 * @date 2018-12-13
 */
@Data
@Table(name = "tb_notice_info")
public class Notice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ntiId;//公告ID

    private Integer partyId;//党支部ID
    private String title;//标题
    private String subTitle;//副标题
    private String cover;//通告封面
    private Integer type;//类型 1文字消息 2图文消息
    private String filePath;//文件地址
    private String operator;//操作人ID（后台管理员或者app用户）
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date releaseTime;//发布时间
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
}

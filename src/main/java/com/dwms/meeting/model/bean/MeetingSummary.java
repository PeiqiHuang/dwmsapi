package com.dwms.meeting.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 会议纪要
 * @author windy
 * @date 2018-12-02
 */
@Data
@Table(name = "tb_meeting_summary")
public class MeetingSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sumId;//纪要ID

    private Integer mtgId;//会议ID
    private String sumTitle;//纪要标题
    private String operator;//撰写人ID（后台管理员或者app用户）
    private Integer source;//来源 1后台创建 2app创建
    private String filePath;//文件地址
    private Integer status;//状态 -1已删除 0待发布 1已发布
    private Date releaseTime;//发布时间
    private Date createTime;//创建时间
}

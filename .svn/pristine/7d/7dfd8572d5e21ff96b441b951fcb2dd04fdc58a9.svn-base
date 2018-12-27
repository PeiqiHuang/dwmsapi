package com.dwms.meeting.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 会议信息
 * @author windy
 * @date 2018-12-02
 */
@Data
@Table(name = "tb_meeting_info")
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mtgId;//会议ID

    private Integer partyId;//党支部ID
    private String mtgName;//主题
    private String mtgTitle;//议题
    private String mtgDesc;//会议要求
    private String address;//地点
    private Integer remind;//会议提醒 1是 0否
    private Integer signIn;//会议签到 1是 0否
    private Integer pushMsg;//会议消息推送 1是 0否
    private String recorder;//记录人userId
    private String signer;//签到负责人userId
    private Integer signHelp;//签到负责人代签或补签 1允许 0禁止
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date beginTime;//会议开始时间
    private Date endTime;//会议结束时间
    private Date createTime;//创建时间
    private String hoster;//主持人userId
}

package com.dwms.meeting.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 会议人员
 * @author windy
 * @date 2018-12-02
 */
@Data
@Table(name = "tb_meeting_user")
public class MeetingUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer muId;//逻辑ID

    private Integer mtgId;//会议ID
    private String userId;//会议参与党员
    private Integer signWay;//签到方式 1自签（扫码） 2代签 3补签
    private String offReason;//请假理由
    private Integer status;//状态 -9请假 -1未确认 0已确认（未签到） 1已签到
    private Integer readSummary;//查看会议纪要 1允许 0禁止
    private Date signTime;//签到时间
    private Date createTime;//创建时间
}

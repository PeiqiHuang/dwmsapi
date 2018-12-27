package com.dwms.meeting.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 会议纪要允许查看人员
 * @author windy
 * @date 2018-12-03
 */
@Data
@Table(name = "tb_meeting_summary_user")
public class MeetingSummaryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msuId;//逻辑ID

    private Integer sumId;//会议纪要ID
    private String userId;//会议参与党员
    private Integer status;//状态 0未读 1已读

}

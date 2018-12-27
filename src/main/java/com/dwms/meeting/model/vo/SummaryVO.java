package com.dwms.meeting.model.vo;

import com.dwms.meeting.model.bean.MeetingSummary;
import lombok.Data;

import java.util.Date;

/**
 * 会议纪要
 * @author windy
 * @date 2018-12-04
 */
@Data
public class SummaryVO extends MeetingSummary {

    private String mtgName;//会议主题
    private String mtgTitle;//会议议题
    private String recorderName;//记录负责人
    private String hosterName;//主持负责人
    private Date beginTime;//会议开始时间
    private Date endTime;//会议结束时间
    private String content;//纪要内容

}

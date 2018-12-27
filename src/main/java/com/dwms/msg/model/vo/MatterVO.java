package com.dwms.msg.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 最近事务VO
 * @author windy
 * @date 2018-12-20
 */
@Data
public class MatterVO implements Serializable {

    private Integer typeId;//事务id,各个类型对应的id
    private String type;//事务分类，1三会一课 2党费收缴 3在线考试 4微党课
    private String title;//事务标题
    private Integer status;//状态，取决于type，type=1(-9已请假 -1未确认 0未签到 1已签到），type=2(0未缴费 1已缴费），type=3(-1待考试 0未通过 1待判分 2已通过），type=4(0学习中 1已完成）
    private Date beginTime;//开始时间

}

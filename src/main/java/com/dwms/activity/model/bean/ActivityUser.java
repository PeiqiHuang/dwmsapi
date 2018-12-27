package com.dwms.activity.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动人员
 * @author windy
 * @date 2018-12-05
 */
@Data
@Table(name = "tb_activity_user")
public class ActivityUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auId;//逻辑id

    private Integer actId;//活动id
    private String userId;//用户id
    private Integer status;//状态 -1未确认 0取消报名 1报名
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
}

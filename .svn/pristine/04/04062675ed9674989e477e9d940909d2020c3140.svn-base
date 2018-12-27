package com.dwms.due.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党费项目
 * @author windy
 * @date 2018-12-17
 */
@Data
@Table(name = "tb_due_info")
public class Due implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dueId;//党费ID

    private Integer partyId;//党支部id
    private String title;//缴费标题
    private String dueDesc;//缴费描述
    private Integer dueItem;//缴费项目 1党费 2特殊党费
    private Integer dueType;//缴费类型 1固定金额 2自由金额
    private Integer due;//缴费金额
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date endTime;//截止日期
    private Date releaseTime;//发布时间
    private Date createTime;//创建时间
    private Integer accId;//党费账户id
}

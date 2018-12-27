package com.dwms.due.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党费党员
 * @author windy
 * @date 2018-12-17
 */
@Data
@Table(name = "tb_due_user")
public class DueUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer duId;//党费党员id

    private Integer dueId;//党费id
    private String userId;//用户id
    private Integer due;//缴费金额
    private Integer payWay;//缴费方式 1微信 2银行卡转账 3支付宝 4现金支付
    private Integer status;//缴费状态 0未缴费 1已缴费 2管理员确认
    private String imgPath;//上传缴费凭证图片地址
    private Date dueTime;//缴费时间
    private Date createTime;//创建时间
}

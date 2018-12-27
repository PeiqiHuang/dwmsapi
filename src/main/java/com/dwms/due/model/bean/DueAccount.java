package com.dwms.due.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党费账户
 * @author windy
 * @date 2018-12-18
 */
@Data
@Table(name = "tb_due_account")
public class DueAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accId;//账户id

    private String accName;//党费账户名称
    private Integer partyId;//党支部id
    private String wechatFilePath;//微信支付图片
    private String alipayFilePath;//支付宝支付图片
    private String payeeName;//收款方姓名
    private String payeeBank;//收款方开户银行
    private String payeeAddress;//收款方开户地址
    private String payeeAccount;//收款方账号
    private String remark;//备注信息
    private String tips;//注意事项
    private Integer status;//状态 0屏蔽 1启用
    private Date updateTime;//修改时间
    private Date createTime;//创建时间
}

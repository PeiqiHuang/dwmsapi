package com.dwms.party.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党支部
 * @author windy
 * @date 2018-12-02
 */
@Data
@Table(name = "tb_party_info")
public class Party implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partyId;//党支部ID

    private String partyName;//党支部名称
    private Integer parentId;//上级党支部ID（没有为0）
    private String address;//所在地址
    private String contract;//联系人
    private String mobile;//联系电话
    private String email;//邮箱
    private Integer source;//来源 1.后台创建 2.app申请入驻
    private Integer status;//状态 1正常 0禁用
    private Date createTime;//创建时间
}

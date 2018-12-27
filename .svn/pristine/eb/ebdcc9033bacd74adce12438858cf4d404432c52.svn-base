package com.dwms.party.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党支部入驻申请
 * @author windy
 * @date 2018-12-02
 */
@Data
@Table(name = "tb_party_apply")
public class PartyApply implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applyId;//申请ID

    private String partyName;//党支部名称
    private Integer memNum;//党组织人数
    private String address;//所在地址
    private String contract;//联系人
    private String mobile;//联系电话
    private String email;//邮箱
    private Integer status;//状态 1审核通过（创建党支部） 0待审核 -1审核失败
    private Integer partyId;//审核通过后对应的党组织ID
    private Date createTime;//创建时间
    private String provCode;//省级代码
    private String cityCode;//市级代码
    private String distCode;//区县代码
}

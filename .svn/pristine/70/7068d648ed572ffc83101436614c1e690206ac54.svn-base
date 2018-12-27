package com.dwms.user.model.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * @author windy
 * @date 2018-11-23
 */
@Data
@Table(name = "tb_user_info")
public class User implements Serializable {

    @Id
    private String userId;//用户id

    private String userName;//用户姓名
    private String mobile;//手机号
    private String password;//密码
    private String avatar;//头像
    private Integer gender;//性别 0未知 1男 2女
    private Integer workStatus;//工作状态 0离职 1在岗 2在职
    private Integer partyId;//党支部id
    private Integer partyType;//党员类型 1申请入党人 2入党积极分子 3发展对象 4预备党员 5正式党员
    private String partyPosts;//党内职务 1普通党员 2支部委员 3支部副书记 4支部书记
    private Date probationaryTime;//转为预备党员日期
    private Date fullTime;//转为正式党员日期
    private String source;//来源
    private Integer status;//状态 0禁用 1启用
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}

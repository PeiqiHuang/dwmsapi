package com.dwms.base.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 白名单ip表
 * @author windy
 * @date 2018-11-23
 */
@Data
@Table(name = "tb_sys_whiteip")
public class WhiteIP implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wiId;//白名单id

    private String ip;//ip地址
    private String description;//ip描述
    private Integer status;//状态 0禁用 1启用
    private Integer adminId;//管理员id
    private Date createTime;//创建时间
    private Date updateTime;//修改时间

}

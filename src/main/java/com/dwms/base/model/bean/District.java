package com.dwms.base.model.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 地区实体
 * @author windy
 * @date 2018-11-21
 */
@Data
@Table(name = "tb_sys_district")
public class District implements Serializable {

    @Id
    private String distCode;//行政区域代码

    private String distName;//区域名称
    private String provCode;//省级代码
    private String cityCode;//市级代码
    private Integer distDegree;//级别(1:省，2:市，3:县)
    private Integer isTerminal;//是否结点(0:否，1是)
    private Integer distType;//地区类型(1:普通,2:直辖市,3:省直管)
    private String fullName;//地区全称
    private Integer distStatus;//地区状态(0:停用，1:启用)
    private Date createTime;//创建时间
    private Date updateTime;//修改时间

}
package com.dwms.base.model.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * app版本信息表
 * @author windy
 * @date 2018-11-23
 */
@Data
@Table(name = "tb_app_version")
public class Version implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer verId;//版本id

    @ApiModelProperty(value = "app标识")
    private String appCode;//app标识
    private String version;//版本
    private String basicVersion;//最低可用版本
    private String content;//版本更新信息
    private String downloadUrl;//下载链接
    private String remark;//备注
    private Integer status;//状态 0禁用 1预发布 2发布
    private Integer adminId;//管理员id
    private Date createTime;//创建时间
    private Date updateTime;//修改时间

}

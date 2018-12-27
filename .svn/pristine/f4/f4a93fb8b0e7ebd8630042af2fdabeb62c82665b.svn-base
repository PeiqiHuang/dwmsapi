package com.dwms.base.model.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 广告位置
 * @author windy
 * @date 2018-11-23
 */
@Data
@Table(name = "tb_advert_key")
public class AdvertKey implements Serializable {

    @Id
    private String adKey;//广告位置key

    private String keyName;//广告位置名称
    private Integer status;//状态 0禁用 1启用
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
}

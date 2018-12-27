package com.dwms.base.model.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 访问令牌实体
 * @author windy
 * @date 2017-05-12
 */
@Data
@Table(name = "tb_sys_accesstoken")
public class AccessToken implements Serializable {

    @Id
    private String accessToken;//访问令牌

    private String secretKey;//密钥
    private String remark;//备注
    private Integer isAuth;//是否鉴权：0否 1是
    private Integer status;//状态：0弃用 1正式
    private Date createTime;//创建时间

}
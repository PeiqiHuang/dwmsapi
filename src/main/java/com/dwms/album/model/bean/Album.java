package com.dwms.album.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 党建相册
 * @author windy
 * @date 2018-12-17
 */
@Data
@Table(name = "tb_album_info")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumId;//相册id

    private Integer partyId;//党支部ID
    private String albumName;//相册名称
    private String albumDesc;//相册描述
    private String cover;//封面图片地址
    private Integer status;//状态 -9已删除 -1已取消 0待发布 1已发布
    private Date releaseTime;//发布时间
    private Date createTime;//创建时间
}

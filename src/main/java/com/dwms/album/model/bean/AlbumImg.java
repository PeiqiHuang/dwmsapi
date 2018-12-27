package com.dwms.album.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 相册图片
 * @author windy
 * @date 2018-12-17
 */
@Data
@Table(name = "tb_album_img")
public class AlbumImg implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aiId;//相册图片id

    private Integer albumId;//相册id
    private String imgPath;//图片地址
    private Integer aiNo;//图片序号 0 1 2 3...
    private Date createTime;//创建时间
}

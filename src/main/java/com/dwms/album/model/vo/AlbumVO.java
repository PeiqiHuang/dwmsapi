package com.dwms.album.model.vo;

import com.dwms.album.model.bean.Album;
import lombok.Data;

/**
 * 相册变量VO
 * @author windy
 * @date 2018-12-17
 */
@Data
public class AlbumVO extends Album {

    private Integer nums;//相册照片数量
}

package com.dwms.album.dao;

import com.dwms.album.model.bean.AlbumImg;
import com.dwms.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 相册图片DAO接口
 * @author windy
 * @date 2018-12-17
 */
public interface IAlbumImgDAO extends BaseMapper<AlbumImg> {

    /**
     * 相册图片列表
     * @author windy
     * @date 2018-12-17
     */
    List<AlbumImg> selectByAlbumId(@Param("albumId") Integer albumId);
}

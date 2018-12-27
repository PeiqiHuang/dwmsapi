package com.dwms.album.service;

import com.dwms.album.model.bean.AlbumImg;
import com.dwms.album.model.form.ListForm;
import com.dwms.album.model.vo.AlbumVO;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;

/**
 * 党建服务
 * @author windy
 * @date 2018-12-17
 */
public interface IAlbumService {

    /**
     * 相册列表
     * @author windy
     * @date 2018-12-17
     */
    ResultBean list(Page<AlbumVO> page, ListForm form);


    /**
     * 相册图片列表
     * @author windy
     * @date 2018-12-17
     */
    ResultBean imgList(Page<AlbumImg> page, Integer albumId);
}

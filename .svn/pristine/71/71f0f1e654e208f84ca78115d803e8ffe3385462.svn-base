package com.dwms.album.controller;

import com.dwms.album.model.bean.AlbumImg;
import com.dwms.album.model.form.ListForm;
import com.dwms.album.model.vo.AlbumVO;
import com.dwms.album.service.IAlbumService;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 党建相册Controller
 * @author windy
 * @date 2018-12-17
 */
@Controller
@RequestMapping("/album/")
public class AlbumController {

    @Resource
    private IAlbumService albumService;

    /**
     * 相册列表
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public ResultBean list(Page<AlbumVO> page, @Valid ListForm form) {
        return albumService.list(page, form);
    }

    /**
     * 相册图片列表
     * @author windy
     * @date 2018-12-07
     */
    @RequestMapping(value = "imgList.do")
    @ResponseBody
    public ResultBean my(Page<AlbumImg> page, @RequestParam Integer albumId) {
        return albumService.imgList(page, albumId);
    }


}

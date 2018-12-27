package com.dwms.album.service.impl;

import com.dwms.album.dao.IAlbumDAO;
import com.dwms.album.dao.IAlbumImgDAO;
import com.dwms.album.model.bean.AlbumImg;
import com.dwms.album.model.form.ListForm;
import com.dwms.album.model.vo.AlbumVO;
import com.dwms.album.model.vo.CountVO;
import com.dwms.album.service.IAlbumService;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.CoverUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 党建相册服务
 * @author windy
 * @date 2018-12-17
 */
@Service
public class AlbumService implements IAlbumService {

    @Resource
    private IAlbumDAO albumDAO;
    @Resource
    private IAlbumImgDAO albumImgDAO;

    @Override
    public ResultBean list(Page<AlbumVO> page, ListForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> albumDAO.selectByPartyId(form.getPartyId()));

        //设置照片数量
        if (!page.isEmpty()) {
            List<AlbumVO> as = CoverUtils.album(page.getResult());
            List<Integer> albumIds = Lists.newArrayList();
            for (AlbumVO a : as) {
                albumIds.add(a.getAlbumId());
            }
            List<CountVO> cs = albumDAO.countNums(albumIds);
            for (AlbumVO a : as) {
                for (CountVO c : cs) {
                    if (a.getAlbumId().equals(c.getAlbumId())) {
                        a.setNums(c.getNums());
                        break;
                    }
                }
                if (a.getNums() == null) {
                    a.setNums(0);
                }
            }
        }
        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean imgList(Page<AlbumImg> page, Integer albumId) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> albumImgDAO.selectByAlbumId(albumId));

        CoverUtils.albumImg(page.getResult());
        return ResultUtils.successBean(PageUtils.map(page));
    }
}

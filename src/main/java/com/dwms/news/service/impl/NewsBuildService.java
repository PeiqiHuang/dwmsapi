package com.dwms.news.service.impl;

import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.HtmlUtils;
import com.dwms.news.dao.INewsBuildDAO;
import com.dwms.news.model.bean.NewsBuild;
import com.dwms.news.model.form.ListForm;
import com.dwms.news.service.INewsBuildService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 党建要闻服务
 * @author windy
 * @date 2018-12-12
 */
@Service
public class NewsBuildService implements INewsBuildService {

    @Resource
    private INewsBuildDAO newsBuildDAO;

    @Override
    public ResultBean index() {
        List<NewsBuild> nbs = CacheUtils.get(CacheConsts.NEW_BUILD, "all", List.class);
        if (CollectionUtils.isEmpty(nbs)) {
            nbs = PageHelper.startPage(1, 3, false).doSelectPage(() -> newsBuildDAO.selectSelective(null));
            HtmlUtils.newsBuild(nbs);
            CacheUtils.put(CacheConsts.NEW_BUILD, "all", nbs);
        }

        return ResultUtils.successBean(nbs);
    }

    @Override
    public ResultBean list(Page<NewsBuild> page, ListForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> newsBuildDAO.selectSelective(form));

        HtmlUtils.newsBuild(page.getResult());
        return ResultUtils.successBean(PageUtils.map(page));
    }
}

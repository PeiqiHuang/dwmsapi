package com.dwms.base.service.impl;

import com.dwms.base.consts.VersionEnum;
import com.dwms.base.dao.IAdvertDAO;
import com.dwms.base.dao.IDistDAO;
import com.dwms.base.dao.IVersionDAO;
import com.dwms.base.mgr.IWhiteIPMgr;
import com.dwms.base.model.bean.District;
import com.dwms.base.model.bean.Version;
import com.dwms.base.model.form.AdvertForm;
import com.dwms.base.model.form.DistForm;
import com.dwms.base.model.form.VersionForm;
import com.dwms.base.model.vo.AdvertVO;
import com.dwms.base.service.ICommonService;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.path.CoverUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 公共服务类
 * @author windy
 * @date 2018-11-26
 */
@Service
public class CommonService implements ICommonService {

    @Resource
    private IAdvertDAO advertDAO;
    @Resource
    private IVersionDAO versionDAO;
    @Resource
    private IWhiteIPMgr whiteIPMgr;
    @Resource
    private IDistDAO distDAO;

    @Override
    public ResultBean advert(Page<AdvertVO> page, AdvertForm form) {
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> advertDAO.selectSelective(form));
        CoverUtils.advert(page.getResult());
        return ResultUtils.successBean(PageUtils.map(page));
    }

    @Override
    public ResultBean version(VersionForm form, String ip) {
        //白名单
        List<String> ws = whiteIPMgr.list();
        int status = VersionEnum.STATUS_RELEASE.getCode();
        if (ws.contains(ip)) {
            status = VersionEnum.STATUS_READY.getCode();
        }

        Version version = versionDAO.selectLast(form.getAppCode(), status);

        if (version == null) {
            return ResultUtils.errorBean(StatusEnum.NOT_FOUND);
        }

        Map<String, Object> data = Maps.newHashMap();
        data.put("version", version);
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean dist(DistForm form) {
        String date = StringUtils.defaultString(form.getDate());
        List<District> dists = CacheUtils.get(CacheConsts.DISTRICT, date, List.class);
        if (CollectionUtils.isEmpty(dists)) {
            dists = distDAO.selectIncrease(date);
            CacheUtils.put(CacheConsts.DISTRICT, date, dists);
        }

        return ResultUtils.successBean(dists);
    }
}

package com.dwms.base.service;

import com.dwms.base.model.form.AdvertForm;
import com.dwms.base.model.form.DistForm;
import com.dwms.base.model.form.VersionForm;
import com.dwms.base.model.vo.AdvertVO;
import com.dwms.common.model.ResultBean;
import com.github.pagehelper.Page;

/**
 * 通用服务
 * @author windy
 * @date 2018-11-26
 */
public interface ICommonService {

    /**
     * 广告列表
     * @author windy
     * @date 2018-11-26
     */
    ResultBean advert(Page<AdvertVO> page, AdvertForm form);

    /**
     * 最新版本
     * @author windy
     * @date 2018-11-26
     */
    ResultBean version(VersionForm form, String ip);

    /**
     * 地区列表
     * @author windy
     * @date 2018-12-02
     */
    ResultBean dist(DistForm form);
}

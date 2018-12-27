package com.dwms.base.mgr.impl;

import com.dwms.base.dao.IWhiteIPDAO;
import com.dwms.base.mgr.IWhiteIPMgr;
import com.dwms.base.model.bean.WhiteIP;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.consts.SysEnum;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 白名单通用层
 * @author windy
 * @date 2018-11-26
 */
@Component
public class WhiteIPMgr implements IWhiteIPMgr {

    @Resource
    private IWhiteIPDAO whiteIPDAO;

    @Override
    public List<String> list() {
        List<String> ips = CacheUtils.get(CacheConsts.WHITE_IP, "all", List.class);
        if (ips == null) {
            Example ie = new Example(WhiteIP.class);
            ie.createCriteria().andEqualTo("status", SysEnum.STATUS_OPEN.getCode());
            List<WhiteIP> ws = whiteIPDAO.selectByExample(ie);
            ips = Lists.newArrayList();
            for (WhiteIP w : ws) {
                ips.add(w.getIp());
            }
            CacheUtils.put(CacheConsts.WHITE_IP, "all", ips);
        }

        return ips;
    }
}

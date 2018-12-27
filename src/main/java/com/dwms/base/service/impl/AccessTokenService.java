package com.dwms.base.service.impl;

import com.dwms.base.dao.IAccessTokenDAO;
import com.dwms.base.model.bean.AccessToken;
import com.dwms.base.service.IAccessTokenService;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 访问令牌服务
 * @author windy
 * @date 2018-11-16
 */
@Service
public class AccessTokenService implements IAccessTokenService {

    @Resource
    private IAccessTokenDAO accessTokenDAO;

    @Override
    public AccessToken get(String accessToken) {
        AccessToken token = CacheUtils.get(CacheConsts.ACCESS_TOKEN, accessToken, AccessToken.class);
        if (token == null) {
            token = accessTokenDAO.selectByPrimaryKey(accessToken);
            if (token != null) {
                CacheUtils.put(CacheConsts.ACCESS_TOKEN, accessToken, token);
            }
        }

        return token;
    }
}
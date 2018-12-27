package com.dwms.common.interceptor;

import com.dwms.base.model.bean.AccessToken;
import com.dwms.base.service.IAccessTokenService;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.consts.SysConsts;
import com.dwms.common.model.RequestModel;
import com.dwms.common.util.ResponseUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.SignUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 访问拦截
 * @author windy
 * @date 2016-11-21
 */
@Component
public class TestInterceptor extends SignInterceptor {

    @Resource
    private IAccessTokenService accessTokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        response.setContentType("text/json;charset=" + SysConsts.CHARSET);
        //访问令牌
        String token = request.getParameter(SysConsts.ACCESS_TOKEN);
        //渠道
        String source = request.getParameter(SysConsts.SOURCE);
        //参数签名
        String sign = request.getParameter(SysConsts.SIGNATURE);
        if (StringUtils.isNotBlank(sign)) {
            //时间戳
            String timestamp = request.getParameter(SysConsts.TIMESTAMP);
            /** ----------------------参数完整度---------------------------------------- */
            if (StringUtils.isBlank(token) || StringUtils.isBlank(source) || StringUtils.isBlank(sign) || StringUtils.isBlank(timestamp)) {
                ResponseUtils.responseToWrite(response, ResultUtils.errorJson(StatusEnum.INVALID_PARAM));
                return false;
            }

            /** ------------------授权Token---------------------------------------- */
            AccessToken accessToken = accessTokenService.get(token);
            String signKey = accessToken == null ? null : accessToken.getSecretKey();
            if (StringUtils.isBlank(signKey)) {
                ResponseUtils.responseToWrite(response, ResultUtils.errorJson(StatusEnum.INVALID_TOKEN));
                return false;
            }
            List<String> filterParam = new ArrayList<>(1);
            filterParam.add(SysConsts.SIGNATURE);
            String paramStr = SignUtils.paramToStr(SignUtils.conversion(request.getParameterMap(), filterParam));
            String serverSign = SignUtils.signParam(paramStr, signKey);
            /** ----------------------签名---------------------------------------- */
            if (!StringUtils.equals(sign, serverSign)) {
                ResponseUtils.responseToWrite(response, ResultUtils.errorJson(StatusEnum.SIGN_ERROR));
                return false;
            }

            /** ----------------------时间戳---------------------------------------- */
            if (SignUtils.isTimeOut(Long.valueOf(timestamp))) {
                ResponseUtils.responseToWrite(response, ResultUtils.errorJson(StatusEnum.TIME_OUT));
                return false;
            }
        }
        //请求线程内放入请求对象
        RequestModel.getInstance(request);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception e) {
        //清空请求线程内对象
        RequestModel.remove();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mav) {
    }
}
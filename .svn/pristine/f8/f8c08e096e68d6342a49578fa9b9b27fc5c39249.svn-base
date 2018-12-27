package com.dwms.common.interceptor;

import com.dwms.common.model.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * dev环境不签名拦截
 * @author windy
 * @date 2016-11-21
 */
@Component
public class DevInterceptor extends SignInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
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
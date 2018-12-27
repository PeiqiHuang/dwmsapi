package com.dwms.common.interceptor;

import com.dwms.common.model.RequestModel;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.IPUtils;
import com.dwms.common.util.SignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 返回响应增强
 * @author 罗俊标
 * @date 2016-11-30
 */
@ControllerAdvice
public class SignAdvice implements ResponseBodyAdvice<ResultBean> {

    private final Logger LOG = LoggerFactory.getLogger(SignAdvice.class);

    @Override
    public ResultBean beforeBodyWrite(ResultBean result, MethodParameter arg1, MediaType arg2, Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest request, ServerHttpResponse response) {
        // 获取线程内请求对象
        RequestModel model = RequestModel.getRequestModel();
        // 请求日志打印
        if (null != model) {
            printAccessLog(model.getRequest(), result, System.currentTimeMillis() - model.getCreateTime());
        }
        //清空请求线程内对象
        RequestModel.remove();
        return result;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> mediaType) {
        return methodParameter.getMethod().getReturnType().isAssignableFrom(ResultBean.class);
    }

    /**
     * 访问日志打印
     * @author 罗俊标
     * @date 2016-12-13
     */
    private void printAccessLog(HttpServletRequest request, ResultBean result, Long cost) {
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(IPUtils.getIpAddr(request)).append("|").append(request.getMethod()).append("|").append(request.getRequestURL().toString()).append("?").append(SignUtils.paramToStr((SignUtils.conversion(request.getParameterMap())))).append("|").append(result.getCode()).append("|").append(result.getMsg()).append("|").append(cost).append("ms");
        LOG.info(sb.toString());
    }
}
package com.dwms.common.model;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求实体类
 * @author 罗俊标
 * @date 2017-1-5
 */
@Data
public class RequestModel {

    private static final ThreadLocal<RequestModel> REQUEST_MODEL = new ThreadLocal<>();//开启线程
    private HttpServletRequest request;//请求对象
    private Long createTime;//请求毫秒数

    private RequestModel() {
    }

    public static RequestModel getInstance(HttpServletRequest request) {
        RequestModel model = new RequestModel();
        model.request = request;
        model.createTime = System.currentTimeMillis();
        REQUEST_MODEL.set(model);
        return model;
    }

    public static RequestModel getRequestModel() {
        return REQUEST_MODEL.get();
    }

    public static void remove() {
        REQUEST_MODEL.remove();
    }

}
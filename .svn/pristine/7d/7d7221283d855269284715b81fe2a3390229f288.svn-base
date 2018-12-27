package com.dwms.common.util;

import com.alibaba.fastjson.JSON;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.consts.SysConsts;
import com.dwms.common.model.ResultBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口响应工具类
 * @author 罗俊标
 * @date 2015-11-10
 */
public class ResultUtils {

    public static ResultBean errorBean(StatusEnum se) {
        return new ResultBean(se.getCode(), se.getMsg());
    }

    public static ResultBean errorBean(StatusEnum se, String msg) {
        return new ResultBean(se.getCode(), msg);
    }

    public static ResultBean errorBean(String code, String msg, Map<String, Object> data) {
        return new ResultBean(code, msg, data);
    }

    public static String errorJson(StatusEnum se) {
        return JSON.toJSONString(new ResultBean(se.getCode(), se.getMsg()));
    }

    public static ResultBean successBean() {
        return new ResultBean(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMsg());
    }

    public static ResultBean successBean(Map<String, Object> data) {
        return new ResultBean(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMsg(), data);
    }

    public static ResultBean successBean(List objs) {
        Map<String, Object> data = new HashMap<String, Object>(1);
        data.put(SysConsts.OBJS, objs);
        return new ResultBean(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMsg(), data);
    }

}
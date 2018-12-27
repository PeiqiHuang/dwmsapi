package com.dwms.common.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * 异步异常处理
 * @author windy
 * @date 2018-11-21
 */
@Slf4j
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    /**
     * 异步异常
     * @author windy
     * @date 2018-11-21
     */
    @Override
    public void handleUncaughtException(Throwable e, Method method, Object... params) {
        printErrorLog(e, method, params);
    }

    /**
     * 异常日志打印
     * @author windy
     * @date 2018-09-17
     */
    private void printErrorLog(Throwable e, Method method, Object... params) {
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(method.getDeclaringClass().getName()).append("|").append(method.getName()).append("|").append(JSON.toJSON(params)).append("\r\n").append("Error Msg:").append(e.getMessage()).append("\r\n");
        StackTraceElement[] stackArray = e.getStackTrace();
        for (StackTraceElement element : stackArray) {
            sb.append(element.toString()).append("\r\n");
        }
        log.error(sb.toString());
    }
}

package com.dwms.common.handler;

import com.dwms.common.consts.StatusEnum;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.IPUtils;
import com.dwms.common.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author windy
 * @date 2018-02-11
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 非法参数异常处理
     * @author windy
     * @date 2018-02-11
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResultBean bindException(HttpServletRequest request, Exception e) {
        System.out.println();
        printErrorLog(request, e);
        return ResultUtils.errorBean(StatusEnum.INVALID_PARAM);
    }

    /**
     * 异常处理
     * @author windy
     * @date 2018-02-11
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultBean exception(HttpServletRequest request, HttpServletResponse response, Exception e) {
        printErrorLog(request, e);
        return ResultUtils.errorBean(StatusEnum.SYSTEM_ERROR);
    }

    /**
     * 异常日志打印
     * @author windy
     * @date 2018-09-17
     */
    private void printErrorLog(HttpServletRequest request, Throwable e) {
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(IPUtils.getIpAddr(request)).append("|").append(request.getMethod()).append("|").append(request.getRequestURL().toString()).append("\r\n").append("Error Msg:").append(e.getMessage()).append("\r\n");
        StackTraceElement[] stackArray = e.getStackTrace();
        for (StackTraceElement element : stackArray) {
            sb.append(element.toString()).append("\r\n");
        }
        log.error(sb.toString());
    }
}
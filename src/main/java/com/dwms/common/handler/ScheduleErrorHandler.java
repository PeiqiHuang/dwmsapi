package com.dwms.common.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ErrorHandler;

/**
 * 定时任务异常处理
 * @author windy
 * @date 2018-11-21
 */
@Slf4j
public class ScheduleErrorHandler implements ErrorHandler {

    /**
     * 异常处理
     * @author windy
     * @date 2018-11-21
     */
    @Override
    public void handleError(Throwable e) {
        printErrorLog(e);
    }

    /**
     * 异常日志打印
     * @author windy
     * @date 2018-09-17
     */
    private void printErrorLog(Throwable e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error Msg:").append(e.getMessage()).append("\r\n");
        StackTraceElement[] stackArray = e.getStackTrace();
        for (StackTraceElement element : stackArray) {
            sb.append(element.toString()).append("\r\n");
        }
        log.error(sb.toString());
    }
}

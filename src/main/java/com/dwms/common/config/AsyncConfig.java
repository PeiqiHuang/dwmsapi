package com.dwms.common.config;

import com.dwms.common.handler.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步配置
 * @author windy
 * @date 2018-09-06
 */
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    /**
     * 异步任务线程池
     * @author windy
     * @date 2018-11-21
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("dwmsapi-async-executor");
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(50);
        executor.setKeepAliveSeconds(3000);
        executor.setQueueCapacity(25);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    /**
     * 异步任务异常处理
     * @author windy
     * @date 2018-11-21
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }
}
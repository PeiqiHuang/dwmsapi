package com.dwms.common.config;

import com.dwms.common.handler.ScheduleErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * 定时任务配置
 * @author windy
 * @date 2018-12-12
 */
@Configuration
@EnableScheduling
@Profile({"test", "prod"})
public class SchedulerConfig {

    /**
     * 定时任务线程池
     * @author windy
     * @date 2018-11-21
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("dwmsapi-async-scheduler");
        scheduler.setPoolSize(50);
        scheduler.setErrorHandler(new ScheduleErrorHandler());
        return scheduler;
    }
}

package com.dwms.common.config;

import com.dwms.common.consts.EnvEnum;
import com.dwms.common.interceptor.DevInterceptor;
import com.dwms.common.interceptor.SignInterceptor;
import com.dwms.common.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Web配置
 * @author windy
 * @date 2018-11-19
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private SysConfig sysConfig;

    /**
     * 设置首页
     * @author windy
     * @date 2018-11-20
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 静态资源访问路径
     * @author windy
     * @date 2018-11-20
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**", "/index.html").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

    }

    /**
     * 配置拦截器
     * @author windy
     * @date 2018-11-19
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**", "/index.html", "/", "swagger-ui.html");
    }

    /**
     * 签名拦截器，dev环境下不签名
     * @author windy
     * @date 2018-11-19
     */
    @Bean
    SignInterceptor signInterceptor() {
        if (EnvEnum.DEV.current(sysConfig.getEnv())) {
            return new DevInterceptor();
        }
        if (EnvEnum.TEST.current(sysConfig.getEnv())) {
            return new TestInterceptor();
        }
        return new SignInterceptor();
    }
}

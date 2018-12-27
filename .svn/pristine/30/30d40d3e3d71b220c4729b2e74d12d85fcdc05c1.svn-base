package com.dwms.common.config;

import com.dwms.common.util.YamlFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 系统配置常量
 * @author windy
 * @date 2018-11-21
 */
@Data
@Configuration
@PropertySources({@PropertySource(value = "classpath:env/${spring.profiles.active}/service.yml", factory = YamlFactory.class), @PropertySource(value = "classpath:env/${spring.profiles.active}/sys.yml", factory = YamlFactory.class)})
public class SysConfig {

    @Value("${spring.profiles.active}")
    private String env;//当前环境
    @Value("${api.service}")
    private String apiService;//API首页
    @Value("${app.aes}")
    private String appAES;//app的aes加密key


    @Value("${file.uploadpath}")
    private String uploadPath;//文件上传路径
    @Value("${file.accesspath}")
    private String accessPath;//文件访问路径
    @Value("${html.root}")
    private String htmlRoot;//html根路径


}

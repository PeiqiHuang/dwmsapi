package com.dwms.common.config;

import com.dwms.common.util.YamlFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.List;

/**
 * 图片配置
 * @author windy
 * @date 2016-12-15
 */
@Data
@Configuration
@PropertySources(@PropertySource(value = "classpath:env/${spring.profiles.active}/sys.yml", factory = YamlFactory.class))
public class ImageConfig {

    @Value("${file.uploadpath}")
    private String uploadPath;// 图片上传路径
    @Value("${file.accesspath}")
    private String accessPath;// 图片访问路径
    @Value("#{'${image.types}'.split(',')}")
    private List<String> imageTypes;// 常见图片类型
    @Value("${image.root}")
    private String root;//图片根路径

    @Value("${image.user.avatar}")
    private String userAvatar;//用户头像
    @Value("${image.mtgSummary}")
    private String mtgSummary;//会议纪要

    @Value("${image.news.build}")
    private String newsBuild;//党建要闻

    @Value("${image.due.user}")
    private String dueUser;//上传缴费凭证图片地址


}
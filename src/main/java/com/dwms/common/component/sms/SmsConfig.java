package com.dwms.common.component.sms;

import com.dwms.common.util.YamlFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 联华信短信配置
 * @author windy
 * @date 2017-04-26
 */
@Data
@Configuration
@PropertySources(@PropertySource(value = "classpath:common/sms.yml", factory = YamlFactory.class))
public class SmsConfig {

    @Value("${wisentsoft.sms.dpToken}")
    private String dpToken;//访问令牌值
    @Value("${wisentsoft.sms.signKey}")
    private String signKey;//加密key值
    @Value("${wisentsoft.sms.url}")
    private String url;//访问地址

}
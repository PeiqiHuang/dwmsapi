package com.dwms.common.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * tkmybatis配置
 * @author windy
 * @date 2018-09-17
 */
@Configuration
@MapperScan({"com.dwms.*.dao"})
public class TKMybatisConfig {

}
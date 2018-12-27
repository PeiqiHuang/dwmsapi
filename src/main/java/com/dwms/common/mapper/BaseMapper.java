package com.dwms.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper
 * @author windy
 * @date 2018-11-16
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
package com.dwms.common.mapper;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

/**
 * Mysql批量插入的IdMapper
 * @author windy
 * @date 2018-11-16
 */
public interface IdMapper<T> extends Mapper<T>, InsertListMapper<T>, InsertUseGeneratedKeysMapper<T> {

}
package com.windy.${tableClass.lowerCaseName}.dao;

import ${baseMapper!"tk.mybatis.mapper.common.Mapper"};
import com.dwms.${tableClass.lowerCaseName}.model.bean.${tableClass.shortClassName};

/**
 * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>DAO接口
 * @author windy
 * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
 */
public interface I${tableClass.shortClassName}DAO extends <#if (baseMapper)??>${baseMapper?substring((baseMapper)?last_index_of(".")+1)}<#else>Mapper</#if><${tableClass.shortClassName}> {

}
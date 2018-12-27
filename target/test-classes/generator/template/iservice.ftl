package com.windy.${tableClass.lowerCaseName}.service;

import com.dwms.common.model.ResultBean;
import com.dwms.${tableClass.lowerCaseName}.model.bean.${tableClass.shortClassName};
import com.github.pagehelper.Page;

/**
 * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>服务接口
 * @author windy
 * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
 */
public interface I${tableClass.shortClassName}Service {

    /**
     * 查询<#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>
     * @author windy
     * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
     */
    ResultBean get(<#if tableClass.pkFields??>${tableClass.pkFields[0].shortTypeName} ${tableClass.pkFields[0].fieldName}</#if>);

    /**
     * 查询<#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>
     * @author windy
     * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
     */
    ResultBean list(Page<${tableClass.shortClassName}> page);

}


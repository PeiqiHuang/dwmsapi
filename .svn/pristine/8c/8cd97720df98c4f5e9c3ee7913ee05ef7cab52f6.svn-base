package com.dwms.${tableClass.lowerCaseName}.service.impl;

import com.dwms.${tableClass.lowerCaseName}.dao.I${tableClass.shortClassName}DAO;
import com.dwms.${tableClass.lowerCaseName}.model.bean.${tableClass.shortClassName};
import com.dwms.${tableClass.lowerCaseName}.service.I${tableClass.shortClassName}Service;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.PageUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
<#assign dao=(tableClass.shortClassName?uncap_first)+"DAO">

/**
 * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>服务实现类
 * @author dwms
 * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
 */
@Service
public class ${tableClass.shortClassName}Service implements I${tableClass.shortClassName}Service{

    @Resource
    private I${tableClass.shortClassName}DAO ${dao};

    @Override
    public ResultBean get(<#if tableClass.pkFields??>${tableClass.pkFields[0].shortTypeName} ${tableClass.pkFields[0].fieldName}</#if>){
${tableClass.shortClassName} ${tableClass.shortClassName?uncap_first} = ${dao}.selectByPrimaryKey(${tableClass.pkFields[0].fieldName});
        Map
<String, Object> data = Maps.newHashMap();
        data.put("${tableClass.shortClassName?uncap_first}", ${tableClass.shortClassName?uncap_first});
        return ResultUtils.successBean(data);
    }

    @Override
    public ResultBean list(Page<${tableClass.shortClassName}> page){
        //count表示是否进行统计语句查询
        boolean count = page.getPageNum() > 0 && page.getPageSize() > 0;
        //当pageSize为0时，表示查询所有数据
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), count).doSelectPage(() -> ${dao}.selectAll());
        return ResultUtils.successBean(PageUtils.map(page));
    }


}


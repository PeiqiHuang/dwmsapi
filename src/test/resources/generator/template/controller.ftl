package com.windy.${tableClass.lowerCaseName}.service.impl;

import com.windy.${tableClass.lowerCaseName}.service.I${tableClass.shortClassName}Service;
import com.windy.${tableClass.lowerCaseName}.model.bean.${tableClass.shortClassName};
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.Page;
import javax.annotation.Resource;

import java.util.List;
<#assign service=(tableClass.shortClassName?uncap_first)+"Service">

/**
 * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>Controller
 * @author windy
 * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
 */
@Controller
@RequestMapping("/${tableClass.lowerCaseName}/")
public class ${tableClass.shortClassName}Controller{

    @Resource
    private I${tableClass.shortClassName}Service ${service};

    /**
     * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}信息</#if>
     * @author windy
     * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
     */
    @RequestMapping("get.do")
    @ResponseBody
    public ResultBean get(<#if tableClass.pkFields??>@RequestParam ${tableClass.pkFields[0].shortTypeName} ${tableClass.pkFields[0].fieldName}</#if>){
        return ${service}.get(<#if tableClass.pkFields??>${tableClass.pkFields[0].fieldName}</#if>);
    }

    /**
     * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}列表</#if>
     * @author windy
     * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ResultBean list(Page<${tableClass.shortClassName}> page){
        return ${service}.list();
    }
}


package com.windy.${tableClass.lowerCaseName}.model.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <#if tableClass.tableRemarks?ends_with("表")>${tableClass.tableRemarks?substring(0,(tableClass.tableRemarks)?length-1)}<#else>${tableClass.tableRemarks}</#if>
 * @author windy
 * @date <#assign dateTime = .now>${dateTime?string["yyyy-MM-dd"]}
 */
@Data
@Table(name = "${tableClass.tableName}"<#if tableClass.indexs??>, indexes={<#list tableClass.indexs as index>@Index(name="${index.key_name}", columnList = "${index.column_name}"<#if index.non_unique==0>,unique=true</#if>),</#list>}</#if>)
public class ${tableClass.shortClassName} implements Serializable{

<#--主键：-->
<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ${field.shortTypeName} ${field.fieldName};//${field.remarks}
    </#list>
</#if>

<#--基础列：-->
<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>
    private ${field.shortTypeName} ${field.fieldName};//${field.remarks}
    </#list>
</#if>
<#--Blob列：-->
<#if tableClass.blobFields??>
    <#list tableClass.blobFields as field>
    private ${field.shortTypeName} ${field.fieldName};//${field.remarks}
    </#list>
</#if>
}
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.dwms.${tableClass.lowerCaseName}.dao.I${tableClass.shortClassName}DAO">

    <resultMap id="BaseResultMap"
               type="com.dwms.${tableClass.lowerCaseName}.model.bean.${tableClass.shortClassName}">
    <#--主键：-->
    <#if tableClass.pkFields??>
        <#list tableClass.pkFields as field>
        <id column="${field.columnName}" property="${field.fieldName}"/>
        </#list>
    </#if>
    <#--基础列：-->
    <#if tableClass.baseFields??>
        <#list tableClass.baseFields as field>
        <result column="${field.columnName}" property="${field.fieldName}"/>
        </#list>
    </#if>
    <#--Blob列：-->
    <#if tableClass.blobFields??>
        <#list tableClass.blobFields as field>
        <result column="${field.columnName}" property="${field.fieldName}"/>
        </#list>
    </#if>
    </resultMap>
</mapper>
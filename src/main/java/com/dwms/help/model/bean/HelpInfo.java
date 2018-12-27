package com.dwms.help.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 10:26
 * @Description: 帮助信息bean
 */
@Data
@Table(name = "tb_help_info")
public class HelpInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId; // 信息id

    private Integer infoType; // 帮助信息类型
    private String title; // 标题
    private String text; // 内容
    private Integer infoStatus; // 帮助信息状态：1正常 0禁用
    private Date createTime; // 创建时间
}

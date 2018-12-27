package com.dwms.help.model.vo;

import lombok.Data;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 11:17
 * @Description: 帮助信息VO
 */
@Data
public class HelpInfoVO {

    private Integer infoId; // 信息id

    private Integer infoType; // 帮助信息类型
    private String title; // 标题
    private String text; // 内容
}

package com.dwms.help.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 10:55
 * @Description: 帮助类型VO
 */
@Data
public class HelpTypeVO {

    private Integer typeId; // 类型编号
    private String typeName; // 类型名称

    List<HelpInfoVO> infoList = new ArrayList<HelpInfoVO>(); // 帮助信息列表
}

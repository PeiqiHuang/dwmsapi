package com.dwms.advice.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Auther: yunbin
 * @Date: 2018/12/18 15:14
 * @Description: 反馈建议bean
 */
@Data
@Table(name = "tb_advice_info")
public class AdviceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adviceId; // 反馈编号
    private String userId; // 反馈人
    private String adviceText; // 反馈内容
    private Date createTime; // 反馈时间
}

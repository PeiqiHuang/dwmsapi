package com.dwms.birthday.model.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 生日祝福bean
 * @author yunbin
 * @date 2018-12-13
 */
@Data
@Table(name = "tb_birthday_wish")
public class BirthdayWish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishId;//祝福id

    private String fromUserId;//祝福人
    private String toUserId;//被祝福人
    private String wishText;//祝福内容
    private Integer wishYear;//生日年份
    private Integer wishType;//祝福类型：1书记寄语2生日感言3他人祝福
    private Date wishTime;//祝福时间
    private Integer status;//状态 0屏蔽 1启用

}

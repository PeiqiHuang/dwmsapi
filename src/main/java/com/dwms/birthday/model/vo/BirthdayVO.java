package com.dwms.birthday.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: yunbin
 * @Date: 2018/12/13 16:56
 * @Description: 政治生日VO
 */

@Data
public class BirthdayVO {

    private String userId; // 用户id
    private String userName; // 用户姓名
    private String avatar;//头像
    private Integer partyId; // 党支部id
    private Date fullTime; // 政治生日
    private Integer years; // 周年
}

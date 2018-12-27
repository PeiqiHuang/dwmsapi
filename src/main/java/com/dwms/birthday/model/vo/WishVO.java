package com.dwms.birthday.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: yunbin
 * @Date: 2018/12/14 09:27
 * @Description: 生日祝福VO
 */
@Data
public class WishVO {

    private Integer wishId;//祝福id
    private String fromUserId;//祝福人
    private String fromUserName;//祝福人姓名
    private String fromUserAvatar;//祝福人头像
    private String toUserId;//被祝福人
    private String wishText;//祝福内容
    private Integer wishYear;//生日年份
    private Integer wishType;//祝福类型：1书记寄语2生日感言3他人祝福
    private Date wishTime;//祝福时间
}

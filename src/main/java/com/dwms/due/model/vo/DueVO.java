package com.dwms.due.model.vo;

import com.dwms.due.model.bean.Due;
import lombok.Data;

/**
 * 党费项目VO
 * @author windy
 * @date 2018-12-17
 */
@Data
public class DueVO extends Due {

    private Integer status;//缴费状态 0未缴费 1已缴费 2管理员确认

}

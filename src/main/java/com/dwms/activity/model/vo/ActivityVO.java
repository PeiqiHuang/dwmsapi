package com.dwms.activity.model.vo;

import com.dwms.activity.model.bean.Activity;
import lombok.Data;

/**
 * 活动变量
 * @author windy
 * @date 2018-12-05
 */
@Data
public class ActivityVO extends Activity {

    private Integer status;//状态 -1已结束 0待报名 1已报名 2进行中
    private Integer nums;//活动报名人数

}

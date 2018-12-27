package com.dwms.birthday.model.form;

import com.dwms.base.model.form.SourceForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yunbin
 * @Date: 2018/12/13 16:52
 * @Description:
 */
@Data
public class RecentBirthForm extends SourceForm {

    @NotNull
    private Integer partyId; //党支部id
    private Integer days = 30; // 近多少天的生日
    private String beginDate; // 起始月日
    private String endDate; //  结束月日
    private Integer rangeType; // 日期范围是否跨年 0 未跨年 1 跨年
}

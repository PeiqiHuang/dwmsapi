package com.dwms.meeting.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * 我的会议form
 * @author windy
 * @date 2018-12-03
 */
@Data
public class MyForm extends UserIdForm {

    @NotNull
    @Range(min = -1, max = 1)
    private Integer type;//类型 -1已结束 1待参加

    @Transient
    private Integer partyId;//党支部id，DAO层查询时使用

}

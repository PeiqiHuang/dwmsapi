package com.dwms.activity.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Transient;

/**
 * 活动列表form
 * @author windy
 * @date 2018-12-05
 */
@Data
public class ListForm extends UserIdForm {

    @Range(min = 0, max = 1)
    private Integer status;//状态 0待报名 1已报名

    @Transient
    private Integer partyId;//党支部id，DAO层查询时使用

}

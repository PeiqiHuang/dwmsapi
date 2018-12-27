package com.dwms.birthday.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 生日祝福form
 * @author yunbin
 * @date 2018-12-13
 */
@Data
public class WishForm extends UserIdForm {

    @NotNull
    @Range(min = 1, max = 3)
    private Integer wishType;//祝福类型：1书记寄语2生日感言3他人祝福

    @NotBlank
    private String toUserId;//被祝福人
    private String wishText;//祝福内容

}

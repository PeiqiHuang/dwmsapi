package com.dwms.birthday.model.form;

import com.dwms.base.model.form.SourceForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: yunbin
 * @Date: 2018/12/14 09:21
 * @Description:祝福列表Form
 */
@Data
public class WishListForm extends SourceForm {

    @NotBlank
    private String toUserId; // 被祝福人id
    @Range(min = 1, max = 3)
    private Integer wishType;//祝福类型：1书记寄语2生日感言3他人祝福
    private Integer wishYear;
}

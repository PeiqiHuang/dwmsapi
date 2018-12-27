package com.dwms.advice.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;

/**
 * @Auther: yunbin
 * @Date: 2018/12/18 15:24
 * @Description: 添加反馈建议form
 */
@Data
public class AddForm extends UserIdForm {
    private String adviceText; // 反馈建议
}

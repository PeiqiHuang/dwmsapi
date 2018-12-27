package com.dwms.help.model.form;

import com.dwms.base.model.form.SourceForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: yunbin
 * @Date: 2018/12/17 14:38
 * @Description: 帮助信息详情
 */
@Data
public class DetailForm extends SourceForm {

    @NotNull
    private Integer infoId; // 帮助信息编号
}

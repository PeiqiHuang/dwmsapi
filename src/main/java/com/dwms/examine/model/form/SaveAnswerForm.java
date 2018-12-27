package com.dwms.examine.model.form;

import com.dwms.base.model.form.UserIdForm;
import com.dwms.examine.model.bean.ExamineQuestionUser;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 保存答案form
 * @author windy
 * @date 2018-12-17
 */
@Data
public class SaveAnswerForm extends UserIdForm {

    @NotNull
    private Integer euId;//考试id
    @NotNull
    private Integer timeLength;//考试用时（秒）
    private List<ExamineQuestionUser> answers;//填写列表

}

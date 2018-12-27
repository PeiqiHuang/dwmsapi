package com.dwms.due.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 确认缴费form
 * @author windy
 * @date 2018-12-17
 */
@Data
public class ConfirmForm extends UserIdForm {

    @NotNull
    private Integer dueId;//党费id
    @NotNull
    private Integer due;//缴费金额，目前只需传整，如1元传1
    @NotNull
    @Min(1)
    @Max(4)
    private Integer payWay;//缴费方式 1微信 2银行卡转账 3支付宝 4现金支付
    private MultipartFile imgPath; //上传缴费凭证

}

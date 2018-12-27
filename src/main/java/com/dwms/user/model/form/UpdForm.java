package com.dwms.user.model.form;

import com.dwms.base.model.form.UserIdForm;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

/**
 * 更新信息form
 * @author windy
 * @date 2018-11-28
 */
@Data
public class UpdForm extends UserIdForm {

    @Range(min = 1, max = 2)
    private Integer gender;//性别 1男 2女

    private MultipartFile avatarImg; //用户头像

    private String avatar;//用户头像，用户修改头像地址

}
package com.dwms.base.model.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 党支部id form
 * @author windy
 * @date 2018-12-13
 */
@Data
public class PartyIdForm {

    @NotNull
    private Integer partyId;//党支部id

}

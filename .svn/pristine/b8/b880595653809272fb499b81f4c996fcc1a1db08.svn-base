package com.dwms.party.controller;

import com.dwms.common.model.ResultBean;
import com.dwms.party.model.form.ApplyForm;
import com.dwms.party.service.IPartyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 党支部Controller
 * @author windy
 * @date 2018-12-02
 */
@RequestMapping("/party/")
@Controller
public class PartyController {

    @Resource
    private IPartyService partyService;

    /**
     * 党支部入驻申请
     * @author windy
     * @date 2018-12-02
     */
    @RequestMapping("apply.do")
    @ResponseBody
    public ResultBean apply(@Valid ApplyForm f) {
        return partyService.saveApply(f);
    }

    /**
     * 党员列表
     * @author windy
     * @date 2018-12-02
     */
    @RequestMapping("users.do")
    @ResponseBody
    public ResultBean users(@RequestParam Integer partyId) {
        return partyService.getUsers(partyId);
    }
}

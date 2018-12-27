package com.dwms.base.controller;

import com.dwms.base.model.form.*;
import com.dwms.base.model.vo.AdvertVO;
import com.dwms.base.service.ICommonService;
import com.dwms.common.component.cache.CacheConsts;
import com.dwms.common.component.cache.CacheUtils;
import com.dwms.common.component.sms.SmsUtils;
import com.dwms.common.component.sms.WisentsoftSms;
import com.dwms.common.consts.HttpConsts;
import com.dwms.common.consts.StatusEnum;
import com.dwms.common.consts.SysConsts;
import com.dwms.common.model.ResultBean;
import com.dwms.common.util.IPUtils;
import com.dwms.common.util.ResultUtils;
import com.dwms.common.util.encrypt.Base64Utils;
import com.github.pagehelper.Page;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共Controller
 * @author windy
 * @date 2018-11-26
 */
@Api(value = "公共模块", tags = "公共模块", hidden = true)
@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private ICommonService commonService;

    /**
     * 获取短信验证码
     * @author windy
     * @date 2017-04-26
     */
    @RequestMapping(value = "/smsCode.do")
    @ResponseBody
    public ResultBean smsCode(@Valid MobileForm form) {
        String code = CacheUtils.get(CacheConsts.SMS_CODE, form.getMobile(), String.class);
        if (StringUtils.isNotBlank(code)) {
            return ResultUtils.errorBean(StatusEnum.SMS_CODE_FREQUENTLY);
        }
        code = SmsUtils.generateSmsCode(4);
        if (!WisentsoftSms.sendCode(form.getMobile(), code)) {//验证码发送失败
            return ResultUtils.errorBean(StatusEnum.SMS_SEND_FAILED);
        }
        //将短信验证码存入缓存
        CacheUtils.put(CacheConsts.SMS_CODE, form.getMobile(), code);
        return ResultUtils.successBean();
    }

    /**
     * 广告列表
     * @author windy
     * @date 2017-05-13
     */
    @ApiOperation(value = "广告列表", httpMethod = HttpConsts.GET)
    @RequestMapping(value = "/advert.do")
    @ResponseBody
    public ResultBean advert(Page<AdvertVO> page, @Valid AdvertForm form) {
        return commonService.advert(page, form);
    }

    /**
     * 版本信息
     * @author windy
     * @date 2017-05-13
     */
    @RequestMapping(value = "/version.do")
    @ResponseBody
    public ResultBean version(@Valid VersionForm form, HttpServletRequest request) {
        return commonService.version(form, IPUtils.getIpAddr(request));
    }

    /**
     * 地区列表
     * @author windy
     * @date 2017-05-13
     */
    @RequestMapping(value = "/dist.do")
    @ResponseBody
    public ResultBean dist(@Valid DistForm form) {
        return commonService.dist(form);
    }

    /**
     * 生成二维码串
     * @author windy
     * @date 2017-03-23
     */
    @RequestMapping("/qrcode.do")
    @ResponseBody
    public ResultBean qrcode(@Valid QRCodeForm form) {
        String qrCode = SysConsts.QR_PREFIX + Base64Utils.encode((form.getProjName() + "/" + form.getBusType() + "/" + form.getCodeVal()).getBytes(Charset.forName(SysConsts.CHARSET)));
        Map<String, Object> data = Maps.newHashMap();
        data.put("QRCode", qrCode);
        return ResultUtils.successBean(data);
    }

    /**
     * 解码二维码串
     * @author windy
     * @date 2017-03-23
     */
    @RequestMapping("/dqrcode.do")
    @ResponseBody
    public ResultBean dqrcode(@Valid DQRCodeForm form) {
        try {
            if (form.getQRCode().startsWith(SysConsts.QR_PREFIX) && form.getQRCode().contains(SysConsts.QR_PREFIX)) {
                String decryptCode = new String(Base64Utils.decode(form.getQRCode().substring(SysConsts.QR_PREFIX.length())), SysConsts.CHARSET);
                String[] params = decryptCode.split("/");
                Map<String, Object> data = new HashMap<>();
                data.put("projName", params[0]);
                data.put("busType", params[1]);
                data.put("codeVal", params[2]);
                return ResultUtils.successBean(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtils.errorBean(StatusEnum.INVALID_PARAM);
    }
}

package com.dwms.common.component.swagger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dwms.common.consts.SysConsts;
import com.google.common.base.Optional;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spring.web.DescriptionResolver;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.io.IOException;

/**
 * 重写notes的plugin
 * 用于修改API文档的notes
 * @author windy
 * @date 2018-11-28
 */
@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 100)
public class OperationNotesReader2 implements OperationBuilderPlugin {

    private final DescriptionResolver descriptions;
    private final String DOC_PATH = "classpath:static/doc.json";


    @Autowired
    public OperationNotesReader2(DescriptionResolver descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public void apply(OperationContext context) {
        String doc = null;
        try {
            doc = FileUtils.readFileToString(ResourceUtils.getFile(DOC_PATH), SysConsts.CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<ApiOperation> methodAnnotation = context.findAnnotation(ApiOperation.class);
        if (doc == null) {
            if (methodAnnotation.isPresent() && org.springframework.util.StringUtils.hasText(methodAnnotation.get().notes())) {
                context.operationBuilder().notes(descriptions.resolve(methodAnnotation.get().notes()));
            }
        } else {
            JSONObject json = JSON.parseObject(doc);
            if (methodAnnotation.isPresent()) {
                String suffixDo = context.requestMappingPattern();
                if (StringUtils.isNotBlank(suffixDo)) {
                    suffixDo = suffixDo.replaceFirst("/", "").replaceAll("/", "_").replaceAll(".do", "");
                    //美化json字符串
                    String note = JSON.toJSONString(json.getJSONObject(suffixDo), true);
                    if (StringUtils.isNotBlank(note)) {
                        note = "\n" + note;
                        note = note.replaceAll("\t", "  ");
                        System.out.println(note);
                        context.operationBuilder().notes(note);
                    } else {
                        context.operationBuilder().notes(descriptions.resolve(methodAnnotation.get().notes()));
                    }
                }
            }
        }
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return SwaggerPluginSupport.pluginDoesApply(delimiter);
    }
}

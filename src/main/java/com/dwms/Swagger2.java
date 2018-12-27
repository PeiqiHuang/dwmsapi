package com.dwms;

import com.dwms.common.consts.EnvEnum;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Set;

/**
 * swagger2配置文件
 * @author windy
 * @date 2018-11-26
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * swagger2的配置文件
     * @author windy
     * @date 2018-11-26
     */
    @Bean
    public Docket createRestApi() {
        //response响应码
        List<ResponseMessage> rs = Lists.newArrayList();
        rs.add(new ResponseMessageBuilder().code(HttpStatus.SC_OK).message("具体信息点击下面 Model 查看").build());

        //produces
        Set<String> produces = Sets.newHashSet();
        produces.add(ContentType.APPLICATION_JSON.toString());

        Docket d = new Docket(DocumentationType.SWAGGER_2);
        d.apiInfo(apiInfo());
        d.enable(!EnvEnum.PROD.current());
        //添加统一说明
        d.useDefaultResponseMessages(false);
        d.globalResponseMessage(RequestMethod.GET, rs);
        d.globalResponseMessage(RequestMethod.HEAD, rs);
        d.globalResponseMessage(RequestMethod.POST, rs);
        d.globalResponseMessage(RequestMethod.PUT, rs);
        d.globalResponseMessage(RequestMethod.PATCH, rs);
        d.globalResponseMessage(RequestMethod.DELETE, rs);
        d.globalResponseMessage(RequestMethod.OPTIONS, rs);
        d.globalResponseMessage(RequestMethod.TRACE, rs);
        d.produces(produces);

        return d.select().apis(RequestHandlerSelectors.basePackage("com.dwms")).paths(PathSelectors.any()).build();

    }

    /**
     * 文件基础信息
     * @author windy
     * @date 2018-11-26
     */
    private ApiInfo apiInfo() {
        ApiInfoBuilder a = new ApiInfoBuilder();
        a.title("党务秘书API接口文档");//页面标题
        a.contact(new Contact("windy", "http://www.baidu.com", "530650681@qq.com"));//联系人
        a.version("1.0");//版本号
        a.description("  1、将yh_token,yh_source,yh_timestamp,yh_timestamp和其他非空值参数进行字典序排序\n" + "            2、将排序后的参数使用URL键值对的格式（即key1=value1&amp;key2=value2…）拼接成字符串s\n" + "            3、将密钥拼接在字符串s后面\n" + "            4、对拼接字符串进行MD5加密，即yh_signature=MD5(s)\n" + "            5、开发阶段不传dw_signature将不触发此校验, 带上dw_signature才会出发校验");//描述
        return a.build();
    }
}
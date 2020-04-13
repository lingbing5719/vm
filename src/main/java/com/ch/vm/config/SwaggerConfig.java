package com.ch.vm.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: 林乐福
 * @Date: 2020/3/4 10:56
 * @Description: controller中的接口API http://ip:port/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //api接口包扫描路径
    //public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.ch.vm.demo.controller";
    public static final String VERSION = "1.0.0";
    public static final String TITLE = "视讯管理平台";
    public static final String DESCRIPTION = "视讯管理平台 API 接口文档";
    public static final String LICENSE = "http://www.bfklb.com/";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))//基于包内所有方法生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//基于注释生成接口文档
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE) //设置文档的标题
                .description(DESCRIPTION) // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .termsOfServiceUrl(LICENSE) // 设置文档的License信息->
                .build();
    }
}
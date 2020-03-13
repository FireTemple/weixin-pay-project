package com.bohan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${swagger2.enable}")
    private boolean enable;

    @Bean
    public Docket createRestApi() {


        List<Parameter> pars = new ArrayList<>();
        //创建两个 可以被放在请求头里面的 token
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder refreshTokenPar = new ParameterBuilder();

        tokenPar.name("authorization").description("swagger测试用(模拟authorization传入)（非必填").modelRef(new ModelRef("string")).parameterType("header").required(false);
        refreshTokenPar.name("refresh_token").description("swagger测试用(模拟刷新token传入) (非必填)").modelRef(new ModelRef("string")).parameterType("header").required(false);

        pars.add(tokenPar.build());
        pars.add(refreshTokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()//这里开始创建 哪些接口会暴露给 ui
                .apis(RequestHandlerSelectors.basePackage("com.bohan.controller"))//需要扫描的包
                .paths(PathSelectors.any())
                .build()//这里结束扫描
                .globalOperationParameters(pars)//配置全局参数 也就是请求头
                .enable(enable);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("author: bohan Xiao")
                .description("Weixin pay project")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}

package com.yinjiansystem.yinjian.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${version}")
	private String version;

	//swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	//http://localhost:8080/swagger-ui.html
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.yinjiansystem.yinjian.controller"))
				.paths(PathSelectors.any())
				.build();
	}

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("阴间服务API")
                //创建人
                .contact(new Contact("平台组", "", ""))
                //版本号
                .version(version)
                //描述
                .description("API 描述")
                .build();
    }
}

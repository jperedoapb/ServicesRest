package com.apb.college.apirest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class Config {

	public Docket collegeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.apb.college"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		
		
		return new ApiInfoBuilder().title("Spring Boot REST API")
				.description("College Management REST API")
				.contact(new Contact("Jaime Peredo", "www.javaguides.net", "jperedoapb@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
	
}

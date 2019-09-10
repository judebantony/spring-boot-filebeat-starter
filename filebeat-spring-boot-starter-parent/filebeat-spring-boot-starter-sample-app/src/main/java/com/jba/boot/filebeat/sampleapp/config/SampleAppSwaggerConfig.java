/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jba.boot.filebeat.sampleapp.constants.SampleAppConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jude
 *
 */
@Configuration
@EnableSwagger2
public class SampleAppSwaggerConfig {


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(SampleAppConstants.BASE_PACKAGE))
				.paths(PathSelectors.regex(SampleAppConstants.URL_PATTERN)).build().apiInfo(apiInfo());
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Filebeat Starter Sample App Api")
				.description("Filebeat Starter Sample App Api")
				.contact(new Contact("Jude Antony", "www.phronesis.com", "judebantony@gmail.com")).license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}

}

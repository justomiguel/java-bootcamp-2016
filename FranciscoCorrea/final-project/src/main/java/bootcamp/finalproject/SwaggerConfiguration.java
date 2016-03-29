package bootcamp.finalproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("info")
				.apiInfo(apiInfo())
				.select()
				.paths(Predicates.not(regex("/error.*")))
				.paths(Predicates.not(regex("/users.*")))
				.paths(regex("/.*"))
				.build();
	}
		
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Shopping Cart")
				.description("Final Project - Bootcamp Java")
				.termsOfServiceUrl("http://taringa.net")
				.contact("correa.francisco.21@gmail.com")
				.license("Apache license Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
				.version("2.0")
				.build();
	}
}

package userapi;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("userapi")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner init(UserRepository userRepository) {
		return (rsp) -> {
			userRepository.save(new User("Tito","password","Franco"));
			userRepository.save(new User("Jean","password","Jean Pierre"));
		};
	}
	
	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("users")
                .apiInfo(metadata())
                .select()
                .paths(regex("/user.*"))
                .build();
    }
     
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Rest API for users using SPRING")
                .description("API Rest to managing users with Spring Boot")
                .termsOfServiceUrl("http://termsofservice.com")
                .contact("Correa J. Francisco")
                .license("Apache License Version 2.0")
                .licenseUrl("www.apache.org/licenses/LICENSE-2.0")
                .version("2.0")
                .build();
    }
}

package br.com.buildit.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Build It REST API (Mobile)")
                .description("API criada para consumo no APP mobile do Build It \n" +
                        "Github: https://github.com/MatheusAprigio/buildit-spring.git")
                .contact(new Contact("Matheus Aprigio da SIlva", "", "matheusaprig@gmail.com"))
                .license("")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }
}

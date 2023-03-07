package es.ordenadores.laptop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.Collections;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
              .select()
              .apis(RequestHandlerSelectors.any())
              .paths(PathSelectors.any())
              .build();
    }
    private ApiInfo apiDetails() {
        return new ApiInfo("Api Details",
                "Api REST docs",
                "1.0",
                "Terms of service",
                new Contact("Gustavo", "https://www.linkedin.com/in/gustavo-garzón",
                        "practicodecocina@gmail.com"),
                "License of API",
                "https://www.linkedin.com/in/gust",
                Collections.EMPTY_LIST);
    }
}

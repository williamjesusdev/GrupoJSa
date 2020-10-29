package io.github.williamjesusdev.grupojsa.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Set CONSUMES_PRODUCES = new HashSet<String>();


    @Bean
    public Docket coreDocket(){
        CONSUMES_PRODUCES.add("application/json");

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.williamjesusdev.grupojsa.core"))
                .paths(PathSelectors.any())
                .build()
                .groupName("API-Central")
                .securitySchemes(singletonList(apiKey()))
                .securityContexts(singletonList(securityContext()))
                .enableUrlTemplating(true)
                .produces(CONSUMES_PRODUCES)
                .consumes(CONSUMES_PRODUCES)
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket empresaDocket(){
        CONSUMES_PRODUCES.add("application/json");

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.williamjesusdev.grupojsa.empresa"))
                .paths(PathSelectors.any())
                .build()
                .groupName("Api-Empresa")
                .securitySchemes(singletonList(apiKey()))
                .securityContexts(singletonList(securityContext()))
                .enableUrlTemplating(true)
                .produces(CONSUMES_PRODUCES)
                .consumes(CONSUMES_PRODUCES)
                .apiInfo(apiInfo());
    }

    @Bean
    public Docket imobiliariaDocket(){
        CONSUMES_PRODUCES.add("application/json");

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.williamjesusdev.grupojsa.imobiliaria"))
                .paths(PathSelectors.any())
                .build()
                .groupName("Api-Imobiliaria")
                .securitySchemes(singletonList(apiKey()))
                .securityContexts(singletonList(securityContext()))
                .enableUrlTemplating(true)
                .produces(CONSUMES_PRODUCES)
                .consumes(CONSUMES_PRODUCES)
                .apiInfo(apiInfo());
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder
                .builder()
                .operationsSorter(OperationsSorter.METHOD)
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API Grupo J. Sá")
                .description("API do Grupo J. Sá, contendo todos os principais serviços...")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact("William Jesus",
                "http://github.com/williamjesusdev",
                "williamjesusti@gmail.com");
    }

    public ApiKey apiKey(){
        return new ApiKey("Bearer", "Authorization", "header");
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("Bearer", authorizationScopes));
    }

}

package com.wkp.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.wkp.offer")
@Configuration
@EnableSwagger2
public class Application {
     
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    @Bean
    public Docket api() {                
        return new Docket(DocumentationType.SWAGGER_2)          
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.wkp.offer"))
          .paths(PathSelectors.ant("/worldpay/*"))
          .build()
          .apiInfo(apiInfo());
    }
     
    private ApiInfo apiInfo() {
         return new ApiInfo(
           "My REST API", 
           "Some custom description of API.", 
           "API TOS", 
           "Terms of service", null, null, null
           );
    }
 
    
}
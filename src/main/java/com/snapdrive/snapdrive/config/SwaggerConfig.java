package com.snapdrive.snapdrive.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SnapDrive API")
                        .version("1.0")
                        .description("API documentation for SnapDrive application")
                        .termsOfService("http://example.com/terms")
                        .contact(new Contact()
                                .name("Developer")
                                .email("vadympantielieienko@gmail.com")
                                .url("http://example.com/contact")));
    }
}

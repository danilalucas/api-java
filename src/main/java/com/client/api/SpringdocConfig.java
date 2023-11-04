package com.client.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringdocConfig {
    @Bean
    OpenAPI springShopOpenAPI() {
        Map<String, Object> extensions = new HashMap<>();
        extensions.put("Desenvolvido por", "Daníla Temoteo Lucas");
        
        return new OpenAPI()
            .info(new Info().title("API Restful")
                .description("API Restful com Springdoc para documentação.")
                .version("1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))

            .contact(new Contact()
            		.name(" Dev: Daníla Temoteo Lucas")
            	    .email("danilatlucas@gmail.com")
                )
            )

            .extensions(extensions)
            
            .externalDocs(new ExternalDocumentation()
                .description("Link do Repositório no GitHub")
                .url("https://github.com/danilalucas/api-java")
            );
    }
}

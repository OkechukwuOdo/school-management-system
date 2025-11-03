package com.justintime.schoolmanagement.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Welcome to \n" +
                                "Enugu Metropolitan School of Technology portal",
                        email = "osmondokey@gmail.com",
                        url = "http/greensphere.agro.com"
                ),
                description = "EMST Documentation",
                title = "EMST",
                version = "1.0",
                license = @License(
                        name = "no Lincence"
                )
        ),
        servers = {
                @Server(description = "local server",
                        url = "http://localhost:8080"
                ),
                @Server(description = "PROD Server",
                        url = "https://prod.com"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Auth",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in= SecuritySchemeIn.HEADER
)
public class OpeApiConfig {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("FrestAndFit")
//                        .description("FrestAndFit Documentation")
//                        .version("1.0")
//                        .contact(new Contact()
//                                .name("Okechukwu")
//                                .email("osmondokey@gmail.com")
//                                .url("http/")
//                        )
//                        .license(new License()
//                                .name("No License")
//                        )
//                )
//                .servers(Arrays.asList(
//                        new Server()
//                                .description("Local Server")
//                                .url("http://localhost:8080"),
//                        new Server()
//                                .description("PROD Server")
//                                .url("https://prod.com")
//                ))
//                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
//                .components(new io.swagger.v3.oas.models.Components()
//                        .addSecuritySchemes("bearerAuth",
//                                new SecurityScheme()
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("bearer")
//                                        .bearerFormat("JWT")
//                                        .description("JWT Auth")
//                        )
//                );
//    }

}
package com.opencourse.cgcoursescrm.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import io.swagger.v3.oas.models.servers.Server;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        String schemeKey = "BearerAuth";

        SecurityScheme securityScheme =
                new SecurityScheme()
                        .type(Type.HTTP)
                        .scheme("Bearer")
                        .bearerFormat("JWT")
                        .in(SecurityScheme.In.HEADER)
                        .name(HttpHeaders.AUTHORIZATION);

        Components components = new Components().addSecuritySchemes(schemeKey, securityScheme);
        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList(schemeKey, new ArrayList<>());

        Server server = new Server();
        server.setDescription("CRM API");
        server.setUrl("/");

        return new OpenAPI()
                .servers(List.of(server))
                .components(components)
                .addSecurityItem(securityRequirement);
    }
}
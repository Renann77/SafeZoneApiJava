package br.com.fiap.safezoneapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SafeZone API - Monitoramento de Desastres Naturais")
                        .version("v1.0")
                        .description(
                                "API RESTful para monitoramento, gestão e alertas de eventos extremos e desastres naturais.")
                        .contact(new Contact()
                                .name("Equipe SafeZone")
                                .email("contato@safezone.com")
                                .url("https://safezone.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação do Projeto SafeZone")
                        .url("https://github.com/Renann77/safezoneapi"));
    }
}

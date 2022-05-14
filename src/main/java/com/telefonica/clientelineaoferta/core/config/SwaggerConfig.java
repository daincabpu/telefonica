package com.telefonica.clientelineaoferta.core.config;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.telefonica.clientelineaoferta.Generated;
import com.telefonica.clientelineaoferta.core.utils.Constantes;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;


@Configuration
@EnableSwagger2
@Generated
public class SwaggerConfig   {
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.telefonica.clientelineaoferta.presentacion.api.controller"))              
          .paths(PathSelectors.any())                          
          .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "wsRenovacionPolizas",
                "Servicios de Busqueda de Clientes lineas y ofertas",
                "v1",
                Constantes.HTTPS_WWW_TELEFONICA_COM,
                new Contact("TELEFONICA DEL PERU", Constantes.HTTPS_WWW_TELEFONICA_COM, "telefonicaperu@telefonica.com.pe"),
                "Licencia del API",
                Constantes.HTTPS_WWW_TELEFONICA_COM,
                Collections.emptyList());
    }
}

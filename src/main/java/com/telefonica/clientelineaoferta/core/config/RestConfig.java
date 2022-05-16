package com.telefonica.clientelineaoferta.core.config;

import java.util.Date;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.clientelineaoferta.Generated;
import com.telefonica.clientelineaoferta.core.utils.IDateTime;


@Configuration
@Generated
public class RestConfig {
	
	@Autowired
	private IDateTime dateTime;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	/*
	@Bean
	public ObjectMapper objectMapper() {
	    return new ObjectMapper();
	}
	*/
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        config.setAllowCredentials(false);
        
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		AbstractConverter<Date, String> dateToString = new AbstractConverter<Date, String>() {
	        @Override
	        protected String convert(Date source) {
	            return dateTime.format(source, "dd/MM/yyyy");
	        }
	    };

        modelMapper.createTypeMap(Date.class, String.class);
        modelMapper.addConverter(dateToString);
		return modelMapper;
	}
	
}

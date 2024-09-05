package com.anjade.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	 @Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("https://www.anjade.es","http://localhost:8080", "https://anjade.es","http://localhost:4200")
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	        registry.addMapping("/procesar_pago").allowedOrigins("http://localhost:4200");
	    }
	 /*
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            .allowedOrigins("http://anjade.es") // Reemplaza con el origen de tu aplicación Angular
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .allowedHeaders("*")
	            .allowCredentials(true);
	        registry.addMapping("/procesar_pago").allowedOrigins("http://anjade.es");
	    }*/
}

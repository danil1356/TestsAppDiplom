package com.example.testsapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:8081","http://192.168.43.81:8081")
                        .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS")
                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                                "Access-Control-Request-Headers","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Methods","Access-Control-Allow-Headers")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
            }
        };
    }
}
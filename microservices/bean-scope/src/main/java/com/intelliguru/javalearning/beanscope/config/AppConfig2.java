package com.intelliguru.javalearning.beanscope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig2 {
    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}

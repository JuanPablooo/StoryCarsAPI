package com.stor.car.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonCustomConfiguration {
    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder jacksonMapperBuilder = new Jackson2ObjectMapperBuilder();
        jacksonMapperBuilder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return jacksonMapperBuilder;
    }
}

package com.example.BS41;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("classpath:myConfiguration.properties")
public class MyConfiguration {

    @Value("${value1}")
    private String value1;

    @Value("${value2}")
    private String value2;

}

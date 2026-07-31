package com.first.first.rest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//using third party class - configuring as spring bean
@Configuration
public class BeanConfigure {
    @Bean
    //register rest template as spring bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

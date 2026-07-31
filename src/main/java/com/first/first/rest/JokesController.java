package com.first.first.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JokesController {
    private RestTemplate restTemplate;
    @Autowired
    public JokesController(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @GetMapping("/joke")
    public String getJoke(){
        // calling a public API using the injected RestTemplate
        return restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", String.class);
    }

}

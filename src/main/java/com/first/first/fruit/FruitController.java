package com.first.first.fruit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {
    private Fruit fruit;
    public FruitController(Fruit fruit){
        this.fruit=fruit;
    }

    @GetMapping("/fruit")
    public String getFruit(){
        return "APPLE";
    }
}

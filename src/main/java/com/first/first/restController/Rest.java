package com.first.first.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Rest {
    //dependency injection
    private Food food;
    private Drink drink;


    //constructor bean injection
    @Autowired
    public Rest(Food food){
        this.food = food;
    }

    //inject property from application.properties
    @Value("${my.name}")
    private String name;

    //setter method bean injection - happens after REST object created
    @Autowired
    public void setDrink(Drink drink){
        this.drink=drink;
    }

    //expose end points in rest controller
    @GetMapping("/")
    public String sendMessage(){
        return name;
    }

    //new endpoint to test restart
    @GetMapping("/test")
    public String testRestart(){
        return "Application restarts";
    }

    @GetMapping("/food")
    public String cookFood(){
        String cookedFood = food.cookMyFood();
        return cookedFood;
    }
    @GetMapping("/drink")
    public String drink(){
        return drink.getDrink();
    }
}

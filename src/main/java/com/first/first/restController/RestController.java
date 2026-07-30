package com.first.first.restController;

import com.first.first.restController.drink.Drink;
import com.first.first.restController.food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    //dependency injection
    private Food food;
    private Drink drink;


    //Parameter 0 of constructor in com.first.first.restController.Rest required a single bean, but 2 were found: - use @Qualifier to resolve bean conflict
    //Bean ID - keep first letter small AmlaPowder = amlaPowder
    @Autowired
    public RestController(@Qualifier("amlaPowder") Food food){
        this.food = food;
        System.out.println("In Constructor: Rest Controller");
    }

    //inject property from application.properties
    @Value("${my.name}")
    private String name;


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

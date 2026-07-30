package com.first.first.restController.drink;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


//@Lazy - spring create bean only if dependency injection happening
@Lazy
@Component
public class Water implements Drink{
    public Water(){
        System.out.println("In Constructor: Water");
    }
    @Override
    public String getDrink() {
        return "This is your chilled water mamm!!!!";
    }
}

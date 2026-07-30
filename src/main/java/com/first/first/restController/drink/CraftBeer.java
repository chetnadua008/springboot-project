package com.first.first.restController.drink;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CraftBeer implements Drink{
    public CraftBeer() {
        System.out.println("In Constructor: CraftBeer");
    }
    @Override
    public String getDrink() {
        return "This is your beer maaam";
    }
}

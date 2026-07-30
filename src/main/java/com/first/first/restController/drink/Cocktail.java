package com.first.first.restController.drink;

import org.springframework.stereotype.Component;

//srping creates Cocktail bean
@Component
public class Cocktail implements Drink {
    public Cocktail(){
        System.out.println("In Constructor: Cocktail");
    }

    @Override
    public String getDrink() {
        return "Here is your cocktail!!!";
    }
}

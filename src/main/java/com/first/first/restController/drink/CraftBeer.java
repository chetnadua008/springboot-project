package com.first.first.restController.drink;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//craftBeer bean injected @Primary annotation
public class CraftBeer implements Drink{
    @Override
    public String getDrink() {
        return "This is your beer maaam";
    }
}

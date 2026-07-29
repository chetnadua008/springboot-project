package com.first.first.restController.drink;

import org.springframework.stereotype.Component;

@Component
public class Water implements Drink{
    @Override
    public String getDrink() {
        return "This is your chilled water mamm!!!!";
    }
}

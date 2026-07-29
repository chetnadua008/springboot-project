package com.first.first.restController.food;

import org.springframework.stereotype.Component;

@Component
public class Oats implements Food{

    @Override
    public String cookMyFood() {
        return "Chocolate Oats are ready!!";
    }
}

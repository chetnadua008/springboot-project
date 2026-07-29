package com.first.first.restController.food;

import org.springframework.stereotype.Component;

@Component
public class Banana implements Food {
    @Override
    public String cookMyFood() {
        return "Have this Banana Bro";
    }
}

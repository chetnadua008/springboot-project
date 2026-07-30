package com.first.first.restController.food;

import org.springframework.stereotype.Component;

@Component
public class AmlaPowder implements Food{

    public AmlaPowder(){
        System.out.println("In Constructor: Amla");
    }
    @Override
    public String cookMyFood() {
        return "Have the amla bro, its good for hair and skin";
    }
}

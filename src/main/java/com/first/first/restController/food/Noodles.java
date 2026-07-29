package com.first.first.restController.food;

import org.springframework.stereotype.Component;

@Component
public class Noodles implements Food{
    @Override
    public String cookMyFood(){
        return new String("Boiling Water, Adds Maggie, Cooks for 8 minutes, Served Hot !!!!");
    }
}

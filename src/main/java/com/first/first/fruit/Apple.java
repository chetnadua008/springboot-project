package com.first.first.fruit;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Apple implements Fruit{

    //bean lifecycle methods
    @PostConstruct
    public void doAfterBeanCreated(){
        System.out.println("Post Construct - Apple");
    }

    @PreDestroy
    public void doBeforeBeanDestroyed(){
        System.out.println("Pre Destroy - Apple");
    }
}

package com.first.first.coach;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//exactly one bean created in memory , referenced by all injections
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach{
    private String name;
    public CricketCoach(){
        name="Default Name";
    }
    @Override
    public String getCoach() {
        return name;
    }

    @Override
    public void setCoach(String newCoach) {
        this.name=newCoach;
    }
}

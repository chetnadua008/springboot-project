package com.first.first.coach;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


//for each dependency injection, new bean created in memory
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach{

    private String coachName;

    public FootballCoach(){
        this.coachName="Default Name";
    }

    @Override
    public String getCoach() {
        return coachName;
    }

    @Override
    public void setCoach(String newCoach){
        this.coachName=newCoach;
    }
}

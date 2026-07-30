package com.first.first.coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    //coach1, coach2 share the bean - Scope is Singleton
    private Coach coach1,coach2;

    //coach3,coach4 have seperate beans - Scope is PROTOTYPE
    private Coach coach3,coach4;

    public CoachController(@Qualifier("cricketCoach")Coach coach1,@Qualifier("cricketCoach") Coach coach2, @Qualifier("footballCoach") Coach coach3,@Qualifier("footballCoach") Coach coach4){
        this.coach1=coach1;
        this.coach2=coach2;
        this.coach3=coach3;
        this.coach4=coach4;
    }

    @GetMapping("/shared/coach")
    public String getCoaches(){
        coach1.setCoach("Chinu");
        String res = coach1.getCoach()+" " +coach2.getCoach();
        return res;
    }

    @GetMapping("/coach")
    public String getSharedCoach(){
        coach3.setCoach("Chetna");
        coach4.setCoach("Purva");
        String res = coach3.getCoach()+" " +coach4.getCoach();
        return res;
    }
}

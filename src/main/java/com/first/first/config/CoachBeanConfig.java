package com.first.first.config;

import com.first.first.coach.Coach;
import com.first.first.coach.GymCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//configure object as spring bean
@Configuration
public class CoachBeanConfig {
    @Bean("gymCoach")
    public GymCoach configureGymCoach(){
        return new GymCoach();
    }
}

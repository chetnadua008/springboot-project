package com.first.first.coach;

public class GymCoach implements Coach{
    private String name;

    public GymCoach(){
        System.out.println("In Constructor: "+getClass().getName());
    }
    @Override
    public String getCoach() {
        return name;
    }

    @Override
    public void setCoach(String newCoach) {
        this.name = newCoach;
    }
}

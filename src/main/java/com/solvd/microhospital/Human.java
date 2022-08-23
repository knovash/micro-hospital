package com.solvd.microhospital;

public  class Human {

    private String name;
    private Gender gender;

    public Human(String name) {
        this.name = name;
    }

    public enum Gender {
        MALE, FEMALE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

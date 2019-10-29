package com;

import exceptions.WrongAgeException;

public class People {
    String name;
    int age;

    public People (String name, int age) throws WrongAgeException {
        this.name=name;

        if (age < 0){
            throw new WrongAgeException("EXCEPTION: Людей младше нуля не бывает");
        }else
            this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

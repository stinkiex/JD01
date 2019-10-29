package com;

import exceptions.MinorAgeException;
import exceptions.WrongAgeException;

public class BuyBeer extends People {

    public BuyBeer(String name, int age) throws WrongAgeException, MinorAgeException {
        super(name, age);
        super.name=name;
        if(age<18){
            throw new MinorAgeException("EXCEPTION: Пивасик младше 18 не продаём!");
        }else{
            super.age=age;

        }

    }

}

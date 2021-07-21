package com.cybertek.tests.day1;

import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        System.out.println("merhaba");

        Faker fk=new Faker();//fayk isim ve soy isim üretme

        for (int i = 0; i <26; i++) {
            System.out.println(fk.name().fullName());

        }




    }
}

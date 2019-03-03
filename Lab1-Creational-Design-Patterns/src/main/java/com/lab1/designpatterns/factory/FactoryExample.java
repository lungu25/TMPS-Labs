package com.lab1.designpatterns.factory;

public class FactoryExample {


    public static void main(String[] args) {

        /*
        Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
         */

        Phone android = PhoneFactory.getPhone(PhoneType.ANDROID);
        Phone iphone = PhoneFactory.getPhone(PhoneType.IPHONE);
        Phone iphone2 = PhoneFactory.getPhone(PhoneType.IPHONE);

        System.out.println(android);
        System.out.println(iphone);
        System.out.println(iphone2);

        /*
        1. Calendar
        2. NumberFormat
         */
    }
}

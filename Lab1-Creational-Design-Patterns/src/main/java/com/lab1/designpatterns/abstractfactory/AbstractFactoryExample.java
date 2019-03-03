package com.lab1.designpatterns.abstractfactory;

public class AbstractFactoryExample {

    public static void main(String[] args) {

        /*
        Abstract Factory design pattern provides approach to code for interface rather than implementation.
Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, for example we can add another sub-class Laptop and a factory LaptopFactory.
Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.
Factory Method provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
         */

        OSFactory factory = AbstractPhoneFactory.getFactory(OSType.ANDROID);
        Phone pixelPhone = factory.create(ManufacturerType.GOOGLE);
        pixelPhone.display();

        OSFactory wfactory = AbstractPhoneFactory.getFactory(OSType.WINDOWS);
        Phone nokiaPhone = wfactory.create(ManufacturerType.MICROSOFT);
        nokiaPhone.display();

        /**
         * DocumentBuilderFactory
         */

    }
}

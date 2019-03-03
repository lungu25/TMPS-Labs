package com.lab1.designpatterns.factory;

public class IPhone extends Phone {
    protected void createPhone() {
        specifications.add(new IPhoneCamera());
        specifications.add(new IPhonePanel());
        specifications.add(new IPhoneProcessor());
    }
}

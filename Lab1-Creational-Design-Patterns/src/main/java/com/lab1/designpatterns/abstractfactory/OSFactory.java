package com.lab1.designpatterns.abstractfactory;

public interface OSFactory {

    Phone create(ManufacturerType manufacturerType);
}

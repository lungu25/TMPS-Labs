package StructuralPattern.Decorator;

import CreationalPattern.FactoryMethod.Phone;

public class UpgradedIosPhone extends IosPhoneDecorator {

    public UpgradedIosPhone(Phone phone){
        super(phone);
    }

    @Override
    public void display(){
        super.display();
        System.out.println("Adding upgrades to IOS phone");
    }

    @Override
    public void sell(){
        System.out.println("iPhone XS was sold");
    }

    @Override
    public void repair(){
        System.out.println("iPhone XS was repaired");
    }

}

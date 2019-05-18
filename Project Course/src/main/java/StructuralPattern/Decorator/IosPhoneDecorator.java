package StructuralPattern.Decorator;

import CreationalPattern.FactoryMethod.Phone;

public abstract class IosPhoneDecorator extends Phone {
    protected Phone phone;

public IosPhoneDecorator(Phone phone) {
    this.phone = phone;
}

@Override
public void display() {
    this.phone.display();
    }

}

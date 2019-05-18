package CreationalPattern.FactoryMethod;

import StructuralPattern.Decorator.UpgradedIosPhone;

public class Main {

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone phone1 = phoneFactory.getPhone("Ios");
        Phone phone2 = phoneFactory.getPhone("Android");
        phone1.display();
        phone2.display();

        Phone upgratedIos = new UpgradedIosPhone(phone1);
        upgratedIos.display();
        upgratedIos.display();
    }
}

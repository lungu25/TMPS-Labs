package BehavioralPatterns.Iterator;

import java.util.ArrayList;

import CreationalPattern.FactoryMethod.Phone;
import CreationalPattern.FactoryMethod.PhoneFactory;
import StructuralPattern.Decorator.UpgradedIosPhone;

public class EnterStore implements Store {
    ArrayList <Phone> phoneList = new ArrayList<Phone>();

    public EnterStore(){
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone phone1 = phoneFactory.getPhone("Ios");
        Phone phone2 = phoneFactory.getPhone("Android");
        Phone upgratedIos = new UpgradedIosPhone(phone1);
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(upgratedIos);

    }

    @Override
    public Iterator getIterator() {
        return new PhoneIterator();
    }

    private class PhoneIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < phoneList.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                return phoneList.toArray()[index++];
            }
            return null;
        }
    }
}

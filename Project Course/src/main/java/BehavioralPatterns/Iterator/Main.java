package BehavioralPatterns.Iterator;

import CreationalPattern.FactoryMethod.Phone;

public class Main {

    public static void main(String[] args) {
        EnterStore enterStore = new EnterStore();

        for(Iterator iterator = enterStore.getIterator(); iterator.hasNext();){
            Phone phone = (Phone) iterator.next();
            phone.ensuranceTemplate();
        }
    }
}

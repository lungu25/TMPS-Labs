package StructuralPattern.Facade;

public class Main {

    public static void main(String[] args) {
        PhoneFacade phoneFacade = new PhoneFacade();
        phoneFacade.displayAndroidPhone();
        phoneFacade.displayIosPhone();
    }
}

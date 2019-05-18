package StructuralPattern.Facade;

import CreationalPattern.FactoryMethod.Phone;
import CreationalPattern.builder.AndroidPhone;
import CreationalPattern.builder.IosPhone;

public class PhoneFacade {
private Phone iosPhone;
private Phone androidPhone;

    IosPhone.Builder builderIos = new IosPhone.Builder()
            .camera("13 MP")
            .authentification("Face ID");

    AndroidPhone.Builder builderAndroid = new AndroidPhone.Builder()
            .camera("12 MP")
            .processor("Snapdragon 625")
            .screenSize("777 Inch");

    public PhoneFacade() {
        this.androidPhone = builderAndroid.build();
        this.iosPhone = builderIos.build();
    }

    public void displayIosPhone(){
    iosPhone.display();
    }

    public void displayAndroidPhone(){
        androidPhone.display();
    }

}

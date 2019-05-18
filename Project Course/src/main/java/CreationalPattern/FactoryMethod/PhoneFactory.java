package CreationalPattern.FactoryMethod;

import CreationalPattern.builder.AndroidPhone;
import CreationalPattern.builder.IosPhone;

public class PhoneFactory {

    IosPhone.Builder builderIos = new IosPhone.Builder()
            .battery(2800)
            .camera("13 MP")
            .authentification("Face ID")
            .processor("Microsoft")
            .screenSize("5.8 Inch");

    AndroidPhone.Builder builderAndroid = new AndroidPhone.Builder()
            .backPanel("Sandstone")
            .frontPanel("AMOLED")
            .camera("12 MP")
            .processor("Snapdragon 625")
            .battery(2800)
            .screenSize("5 Inch")
            .phoneCase(true);

    public Phone getPhone(String phone) {
        if(phone.equals(null)) return null;

        if(phone.equalsIgnoreCase("Android")) {
            return builderAndroid.build();
        } else if(phone.equalsIgnoreCase("Ios")) {
            return builderIos.build();
        }
        return null;
    }
}

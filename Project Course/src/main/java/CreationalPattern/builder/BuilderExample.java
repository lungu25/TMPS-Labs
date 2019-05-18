package CreationalPattern.builder;

import CreationalPattern.FactoryMethod.PhoneFactory;

public class BuilderExample {

    public static void main(String[] args) {

        AndroidPhone.Builder builder = new AndroidPhone.Builder()
                .backPanel("Sandstone")
                .frontPanel("AMOLED")
                .camera("12 MP")
                .processor("Snapdragon 625")
                .battery(2800)
                .screenSize("5 Inch")
                .phoneCase(true);

        AndroidPhone androidPhone = builder.build();

        androidPhone.display();

        IosPhone.Builder builderIos = new IosPhone.Builder()
                .battery(2800)
                .camera("13 MP")
                .authentification("Face ID")
                .processor("Microsoft")
                .screenSize("5.8 Inch");
        IosPhone iosPhone = builderIos.build();
        iosPhone.display();
    }
}

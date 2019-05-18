package CreationalPattern.builder;

import CreationalPattern.FactoryMethod.Phone;

public class AndroidPhone extends Phone {

    /*


First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class. We should follow the naming convention and if the class name is Computer then builder class should be named as ComputerBuilder.
Java Builder class should have a public constructor with all the required attributes as parameters.
Java Builder class should have methods to set the optional parameters and it should return the same Builder object after setting the optional attribute.
The final step is to provide a build() method in the builder class that will return the Object needed by client program. For this we need to have a private constructor in the Class with Builder class as argument.
     */

    public static class Builder {
        private String frontPanel;
        private String backPanel;
        private String processor;
        private String camera;
        private Integer battery;
        private String screenSize;
        private Boolean phoneCase;

        public Builder() {
        }

        public AndroidPhone build() {
            return new AndroidPhone(this);
        }

        public Builder frontPanel(String frontPanel) {
            this.frontPanel = frontPanel;
            return this;
        }

        public Builder backPanel(String backPanel) {
            this.backPanel = backPanel;
            return this;
        }

        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder camera(String camera) {
            this.camera = camera;
            return this;
        }

        public Builder battery(Integer battery) {
            this.battery = battery;
            return this;
        }

        public Builder screenSize(String screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder phoneCase(Boolean phoneCase) {
            this.phoneCase = phoneCase;
            return this;
        }


    }

    private String frontPanel;
    private String backPanel;
    private String processor;
    private String camera;
    private Integer battery;
    private String screenSize;
    private Boolean phoneCase;

    private AndroidPhone(Builder builder) {
        this.frontPanel = builder.frontPanel;
        this.backPanel = builder.backPanel;
        this.processor = builder.processor;
        this.camera = builder.camera;
        this.battery = builder.battery;
        this.screenSize = builder.screenSize;
        this.phoneCase = builder.phoneCase;

    }

    public String getFrontPanel() {
        return frontPanel;
    }

    public String getBackPanel() {
        return backPanel;
    }

    public String getProcessor() {
        return processor;
    }

    public String getCamera() {
        return camera;
    }

    public Integer getBattery() {
        return battery;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public Boolean isPhoneCase() {
        return phoneCase;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AndroidPhone{");
        sb.append("frontPanel='").append(frontPanel).append('\'');
        sb.append(", backPanel='").append(backPanel).append('\'');
        sb.append(", processor='").append(processor).append('\'');
        sb.append(", camera='").append(camera).append('\'');
        sb.append(", battery='").append(battery).append('\'');
        sb.append(", screenSize='").append(screenSize).append('\'');
        sb.append(", phoneCase='").append(phoneCase).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }

    public void sell(){
        System.out.println("Samsung galaxy note 7 was sold");
    }

    public void repair(){
        System.out.println("Samsung galaxy note 7 was repaired");
    }
}

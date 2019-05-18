package CreationalPattern.builder;

import CreationalPattern.FactoryMethod.Phone;

public class IosPhone extends Phone {

    /*


First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class. We should follow the naming convention and if the class name is Computer then builder class should be named as ComputerBuilder.
Java Builder class should have a public constructor with all the required attributes as parameters.
Java Builder class should have methods to set the optional parameters and it should return the same Builder object after setting the optional attribute.
The final step is to provide a build() method in the builder class that will return the Object needed by client program. For this we need to have a private constructor in the Class with Builder class as argument.
     */

    public static class Builder {
        private String authentification;
        private String processor;
        private String camera;
        private Integer battery;
        private String screenSize;

        public Builder() {
        }

        public IosPhone build() {
            return new IosPhone(this);
        }

        public Builder authentification(String authentification) {
            this.authentification = authentification;
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



    }

    private String authentification;
    private String processor;
    private String camera;
    private Integer battery;
    private String screenSize;

    private IosPhone(Builder builder) {
        this.processor = builder.processor;
        this.camera = builder.camera;
        this.battery = builder.battery;
        this.screenSize = builder.screenSize;
        this.authentification = builder.authentification;
    }

    public String getAuthentification() {
        return authentification;
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



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("IosPhone{");
        sb.append("authentification='").append(authentification).append('\'');
        sb.append(", processor='").append(processor).append('\'');
        sb.append(", camera='").append(camera).append('\'');
        sb.append(", battery='").append(battery).append('\'');
        sb.append(", screenSize='").append(screenSize).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }

    public void sell(){
        System.out.println("iPhone X was sold");
    }

    public void repair(){
        System.out.println("iPhone X was repaired");
    }
}

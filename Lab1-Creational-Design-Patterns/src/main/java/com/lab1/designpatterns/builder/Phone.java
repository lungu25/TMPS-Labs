package com.lab1.designpatterns.builder;

public class Phone {

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

        public Builder() {
        }

        public Phone build() {
            return new Phone(this);
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


    }

    private String frontPanel;
    private String backPanel;
    private String processor;
    private String camera;

    private Phone(Builder builder) {
        this.frontPanel = builder.frontPanel;
        this.backPanel = builder.backPanel;
        this.processor = builder.processor;
        this.camera = builder.camera;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("frontPanel='").append(frontPanel).append('\'');
        sb.append(", backPanel='").append(backPanel).append('\'');
        sb.append(", processor='").append(processor).append('\'');
        sb.append(", camera='").append(camera).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

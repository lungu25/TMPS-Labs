package lab2.designpatterns.decorator;

public class AndroidPhone extends SmartPhone {
    public AndroidPhone(Phone phone) {
        super(phone);
    }

    @Override
    public String build() {
        return super.build() + addOS();
    }

    private String addOS() {
        return "Android OS v6.0";
    }
}

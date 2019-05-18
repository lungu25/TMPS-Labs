package CreationalPattern.FactoryMethod;

public abstract class Phone {
  abstract public void display();
  abstract public void repair();
  abstract public void sell();
public final void ensuranceTemplate(){
  System.out.println("============Begin of Template pattern:=============");
  display();
  sell();
  repair();
  display();
  System.out.println("============End of Template pattern:=============");
}
}

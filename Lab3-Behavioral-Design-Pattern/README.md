# Behavioral Design Patterns
## Table of Contents
- [State](#state)
- [Template-method](#template-method)
- [Proxy](#proxy)
- [Chain-of-responsibility](#chain-of-responsibility)
- [Iterator](#iterator)

## State <a name="State"></a>
Real world example:
Suppose we want to implement a TV Remote with a simple button to perform action. If the State is ON, it will turn on the TV and if state is OFF, it will turn off the TV.
The state pattern is a behavioral software design pattern that implements a state machine in an object-oriented way. 
With the state pattern, a state machine is implemented by implementing each individual state as a derived class of the state pattern interface, and implementing state transitions by invoking methods defined by the pattern's super class.

Implementation (TV Remote example)
We will use State pattern to implement TV Remote example.
Step 1 : Create an interface.
public interface State {
 public void doAction();
}
Step 2: State Design Pattern Concrete State Implementations
In our example, we can have two states – one for turning TV on and another to turn it off. So we will create two concrete state implementations for these behaviors.

public class TVStartState implements State {
 @Override
 public void doAction() {
  System.out.println("TV is turned ON");
 }
}
public class TVStopState implements State {
 @Override
 public void doAction() {
  System.out.println("TV is turned OFF");
 }
}
Step 3 : Let's implement our Context object that will change its behavior based on its internal state.
public class TVContext implements State {

 private State tvState;

 public void setState(State state) {
  this.tvState=state;
 }

 public State getState() {
  return this.tvState;
 }

 @Override
 public void doAction() {
  this.tvState.doAction();
 }

}
Notice that Context also implements State and keep a reference of its current state and forwards the request to the state implementation.
Step 4 :  Now let’s write a simple program to test our state pattern implementation of TV Remote.
public class TVRemote {

 public static void main(String[] args) {
  TVContext context = new TVContext();
  State tvStartState = new TVStartState();
  State tvStopState = new TVStopState();
  
  context.setState(tvStartState);
  context.doAction();
  
     context.setState(tvStopState);
  context.doAction(); 
 }
}
Step 5 : Output
TV is turned ON
TV is turned OFF

## Template-method <a name="template-method"></a>

Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.

Participants
1. AbstractClass
defines abstract primitive operations that concrete subclasses define to implement steps of an algorithm.
implements a template method defining the skeleton of an algorithm.The template method calls primitive operations as well as operations defined in AbstractClass or those of other objects. 
2. ConcreteClass 
implements the primitive operations to carry out subclass-specific steps of the algorithm.
Collaborations
ConcreteClass relies on AbstractClass to implement the invariant steps of the algorithm.
Source Code
Follow the steps to implementation of Template design pattern.
Let's create a coffee beverage system
Step 1: Create CaffeineBeverage class ,which defines skeleton for the algorithm.
/**
 * CaffeineBeverage defines skeleton for the algorithm.
 * @author RAMESH
 *
 */
public abstract class CaffeineBeverage {
  
 final void prepareRecipe() {
  boilWater();
  brew();
  pourInCup();
  addCondiments();
 }
 
 abstract void brew();
  
 abstract void addCondiments();
 
 void boilWater() {
  System.out.println("Boiling water");
 }
  
 void pourInCup() {
  System.out.println("Pouring into cup");
 }
}
Step 2 :  Create a Coffee class , which extends abstract CaffeineBeverage class and implements abstract methods.
public class Coffee extends CaffeineBeverage {
 public void brew() {
  System.out.println("Dripping Coffee through filter");
 }
 public void addCondiments() {
  System.out.println("Adding Sugar and Milk");
 }
}
Step 3 :  Create a Tea class which extends abstract CaffeineBeverage class and implements abstract methods.
public class Tea extends CaffeineBeverage {
 public void brew() {
  System.out.println("Steeping the tea");
 }
 public void addCondiments() {
  System.out.println("Adding Lemon");
 }
}
Step 4 : With a hook, we can override a method or not, It's our choice , If we don't then abstract class provides default implementation.
public abstract class CaffeineBeverageWithHook {
 
 void prepareRecipe() {
  boilWater();
  brew();
  pourInCup();
  if (customerWantsCondiments()) {
   addCondiments();
  }
 }
 
 abstract void brew();
 
 abstract void addCondiments();
 
 void boilWater() {
  System.out.println("Boiling water");
 }
 
 void pourInCup() {
  System.out.println("Pouring into cup");
 }
 
 boolean customerWantsCondiments() {
  return true;
 }
}
Step 5 : Let's override the hook() method and provide the own implementation.
import java.io.*;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
 
 public void brew() {
  System.out.println("Dripping Coffee through filter");
 }
 
 public void addCondiments() {
  System.out.println("Adding Sugar and Milk");
 }
 
 public boolean customerWantsCondiments() {

  String answer = getUserInput();

  if (answer.toLowerCase().startsWith("y")) {
   return true;
  } else {
   return false;
  }
 }
 
 private String getUserInput() {
  String answer = null;

  System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  try {
   answer = in.readLine();
  } catch (IOException ioe) {
   System.err.println("IO error trying to read your answer");
  }
  if (answer == null) {
   return "no";
  }
  return answer;
 }
}
import java.io.*;

public class TeaWithHook extends CaffeineBeverageWithHook {
 
 public void brew() {
  System.out.println("Steeping the tea");
 }
 
 public void addCondiments() {
  System.out.println("Adding Lemon");
 }
 
 public boolean customerWantsCondiments() {

  String answer = getUserInput();

  if (answer.toLowerCase().startsWith("y")) {
   return true;
  } else {
   return false;
  }
 }
 
 private String getUserInput() {
  // get the user's response
  String answer = null;

  System.out.print("Would you like lemon with your tea (y/n)? ");

  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  try {
   answer = in.readLine();
  } catch (IOException ioe) {
   System.err.println("IO error trying to read your answer");
  }
  if (answer == null) {
   return "no";
  }
  return answer;
 }
}
Step  6 : Test the above implementation.
Let's create a hot coffee and hot tea, here customer needs to decide whether he/she wants condiment by input.
public class BeverageTestDrive {
 public static void main(String[] args) {
 
  Tea tea = new Tea();
  Coffee coffee = new Coffee();
 
  System.out.println("\nMaking tea...");
  tea.prepareRecipe();
 
  System.out.println("\nMaking coffee...");
  coffee.prepareRecipe();

 
  TeaWithHook teaHook = new TeaWithHook();
  CoffeeWithHook coffeeHook = new CoffeeWithHook();
 
  System.out.println("\nMaking tea...");
  teaHook.prepareRecipe();
 
  System.out.println("\nMaking coffee...");
  coffeeHook.prepareRecipe();
 }
}
Output :
Making tea...
Boiling water
Steeping the tea
Pouring into cup
Adding Lemon

Making coffee...
Boiling water
Dripping Coffee through filter
Pouring into cup
Adding Sugar and Milk

Making tea...
Boiling water
Steeping the tea
Pouring into cup
Would you like lemon with your tea (y/n)? y
Adding Lemon

Making coffee...
Boiling water
Dripping Coffee through filter
Pouring into cup
Would you like milk and sugar with your coffee (y/n)? y
Adding Sugar and Milk


## Proxy <a name="proxy"></a>

Delegation is a way of reusing and extending the behavior of a class. It works writing a new class that incorporates the functionality of the original class by using an instance of the original class and calling its methods.
The advantage of delegation is that it is easy to compose behavior at runtime.
Let's take an example of Printers Implementation.
 In this example the delegates are CanonPrinter, EpsonPrinter or HpPrinter they all implement Printer. The PrinterController is a delegator class which also implements Printer.
PrinterController is not responsible for the actual desired action but is actually delegated to a helper class either CanonPrinter, EpsonPrinter or HpPrinter. The consumer does not have or require knowledge of the actual class carrying out the action, only the container on which they are calling.

Step 1: First create Printer interface that both the Controller and the Delegate classes will implement.
public interface Printer {
  void print(final String message);
}
Step 2: Specialised Implementation of Printer for a Canon Printer, in this case the message to be printed is appended to "Canon Printer : ".
public class CanonPrinter implements Printer {

  private static final Logger LOGGER = LoggerFactory.getLogger(CanonPrinter.class);
  @Override
  public void print(String message) {
    LOGGER.info("Canon Printer : {}", message);
  }

}
Step 3: Specialised Implementation of Printer for a Epson Printer, in this case the message to be printed is appended to "Epson Printer : ".
public class EpsonPrinter implements Printer {

  private static final Logger LOGGER = LoggerFactory.getLogger(EpsonPrinter.class);
  @Override
  public void print(String message) {
    LOGGER.info("Epson Printer : {}", message);
  }

}
Step 4: Specialised Implementation of Printer for a HP Printer, in this case the message to be printed is appended to "HP Printer : ".
public class HpPrinter implements Printer {

  private static final Logger LOGGER = LoggerFactory.getLogger(HpPrinter.class);
  @Override
  public void print(String message) {
    LOGGER.info("HP Printer : {}", message);
  }

}
Step 5: it's time to implement Delegator class.
 Delegator Class to delegate the implementation of the Printer.
 This ensures two things:
when the actual implementation of the Printer class changes the delegation will still be operational
the actual benefit is observed when there are more than one implementors and they share a delegation control.
public class PrinterController implements Printer {

  private final Printer printer;

  public PrinterController(Printer printer) {
    this.printer = printer;
  }
  @Override
  public void print(String message) {
    printer.print(message);
  }
}
Step 6: Let's test the Delegation pattern using the main method.
public class App {

  public static final String MESSAGE_TO_PRINT = "hello world";

  /**
   * Program entry point
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    PrinterController hpPrinterController = new PrinterController(new HpPrinter());
    PrinterController canonPrinterController = new PrinterController(new CanonPrinter());
    PrinterController epsonPrinterController = new PrinterController(new EpsonPrinter());

    hpPrinterController.print(MESSAGE_TO_PRINT);
    canonPrinterController.print(MESSAGE_TO_PRINT);
    epsonPrinterController.print(MESSAGE_TO_PRINT);
  }

}

## Chain-of-responsibility <a name="chain-of-responsibility"></a>

It is belongs to behavioral design patterns catalog.
Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.
Real world example
The Orc King gives loud orders to his army. The closest one to react is the commander, then officer and then soldier. The commander, officer and soldier here form a chain of responsibility.
In plain words
It helps building a chain of objects. Request enters from one end and keeps going from object to object till it finds the suitable handler.
Participants
1. Handler
defines an interface for handling requests.
(optional) implements the successor link.
2. ConcreteHandler
handles requests it is responsible for.
can access its successor.
if the ConcreteHandler can handle the request, it does so; otherwise
it forwards the request to its successor.
3. Client
initiates the request to a ConcreteHandler object on the chain.
Collaborations
When a client issues a request, the request propagates along the chain until a ConcreteHandler object takes responsibility for handling it.
Source code
 Step 1 : First we have the request class
public class Request {

  private final RequestType requestType;
  private final String requestDescription;
  private boolean handled;

  public Request(final RequestType requestType, final String requestDescription) {
    this.requestType = Objects.requireNonNull(requestType);
    this.requestDescription = Objects.requireNonNull(requestDescription);
  }

  public String getRequestDescription() { return requestDescription; }

  public RequestType getRequestType() { return requestType; }

  public void markHandled() { this.handled = true; }

  public boolean isHandled() { return this.handled; }

  @Override
  public String toString() { return getRequestDescription(); }
}

public enum RequestType {
  DEFEND_CASTLE, TORTURE_PRISONER, COLLECT_TAX
}
Step 2 : Then the request handler hierarchy
public abstract class RequestHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(RequestHandler.class);
  private RequestHandler next;

  public RequestHandler(RequestHandler next) {
    this.next = next;
  }

  public void handleRequest(Request req) {
    if (next != null) {
      next.handleRequest(req);
    }
  }

  protected void printHandling(Request req) {
    LOGGER.info("{} handling request \"{}\"", this, req);
  }

  @Override
  public abstract String toString();
}

public class OrcCommander extends RequestHandler {
  public OrcCommander(RequestHandler handler) {
    super(handler);
  }

  @Override
  public void handleRequest(Request req) {
    if (req.getRequestType().equals(RequestType.DEFEND_CASTLE)) {
      printHandling(req);
      req.markHandled();
    } else {
      super.handleRequest(req);
    }
  }

  @Override
  public String toString() {
    return "Orc commander";
  }
}

// OrcOfficer and OrcSoldier are defined similarly as OrcCommander

Step 3 :Then we have the Orc King who gives the orders and forms the chain
public class OrcKing {
  RequestHandler chain;

  public OrcKing() {
    buildChain();
  }

  private void buildChain() {
    chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
  }

  public void makeRequest(Request req) {
    chain.handleRequest(req);
  }
}
Step 4 : Then it is used as follows
OrcKing king = new OrcKing();
king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle")); // Orc commander handling request "defend castle"
king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "torture prisoner")); // Orc officer handling request "torture prisoner"
king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax")); // Orc soldier handling request "collect tax"
Applicability
Use Chain of Responsibility when
more than one object may handle a request, and the handler isn't known a prior. The handler should be ascertained automatically
you want to issue a request to one of several objects without specifying the receiver explicitly
the set of objects that can handle a request should be specified dynamically.

## Iterator <a name="iterator"></a>
It is belongs to behavioral design patterns catalog.
Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
Participants
1. Iterator
defines an interface for accessing and traversing elements.
2. ConcreteIterator
 implements the Iterator interface. 
 keeps track of the current position in the traversal of the aggregate.
3. Aggregate
defines an interface for creating an Iterator object.
4. ConcreteAggregate
implements the Iterator creation interface to return an instanceof the proper ConcreteIterator.
Collaborations
 A ConcreteIterator keeps track of the current object in the aggregate and can compute the succeeding object in the traversal. 
Source code
Step 1: Create a Iterator interface.
/**
 * 
 * ItemIterator interface.
 * 
 */
public interface ItemIterator {

  boolean hasNext();

  Item next();
}
Step 2: Create Item class (iterating list of items).
public class Item {

  private ItemType type;
  private String name;

  public Item(ItemType type, String name) {
    this.setType(type);
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  public ItemType getType() {
    return type;
  }

  public final void setType(ItemType type) {
    this.type = type;
  }
}
Step 3 :  Create enum for ItemTypes
public enum ItemType {

  ANY, WEAPON, RING, POTION

}
Step 4: Create TreasureChest class which holds a collection of items.
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * TreasureChest, the collection class.
 * 
 */
public class TreasureChest {

  private List<Item> items;

  /**
   * Constructor
   */
  public TreasureChest() {
    items = new ArrayList<>();
    items.add(new Item(ItemType.POTION, "Potion of courage"));
    items.add(new Item(ItemType.RING, "Ring of shadows"));
    items.add(new Item(ItemType.POTION, "Potion of wisdom"));
    items.add(new Item(ItemType.POTION, "Potion of blood"));
    items.add(new Item(ItemType.WEAPON, "Sword of silver +1"));
    items.add(new Item(ItemType.POTION, "Potion of rust"));
    items.add(new Item(ItemType.POTION, "Potion of healing"));
    items.add(new Item(ItemType.RING, "Ring of armor"));
    items.add(new Item(ItemType.WEAPON, "Steel halberd"));
    items.add(new Item(ItemType.WEAPON, "Dagger of poison"));
  }

  ItemIterator iterator(ItemType itemType) {
    return new TreasureChestItemIterator(this, itemType);
  }

  /**
   * Get all items
   */
  public List<Item> getItems() {
    List<Item> list = new ArrayList<>();
    list.addAll(items);
    return list;
  }

}
Step 5: Let's create an Iterator implementation class TreasureChestItemIterator.java
import java.util.List;

/**
 * 
 * TreasureChestItemIterator
 *
 */
public class TreasureChestItemIterator implements ItemIterator {

  private TreasureChest chest;
  private int idx;
  private ItemType type;

  /**
   * Constructor
   */
  public TreasureChestItemIterator(TreasureChest chest, ItemType type) {
    this.chest = chest;
    this.type = type;
    this.idx = -1;
  }

  @Override
  public boolean hasNext() {
    return findNextIdx() != -1;
  }

  @Override
  public Item next() {
    idx = findNextIdx();
    if (idx != -1) {
      return chest.getItems().get(idx);
    }
    return null;
  }

  private int findNextIdx() {

    List<Item> items = chest.getItems();
    boolean found = false;
    int tempIdx = idx;
    while (!found) {
      tempIdx++;
      if (tempIdx >= items.size()) {
        tempIdx = -1;
        break;
      }
      if (type.equals(ItemType.ANY) || items.get(tempIdx).getType().equals(type)) {
        break;
      }
    }
    return tempIdx;
  }
}
Step 6: Create App class to test Iterator design pattern.
public class App {

  /**
   * Program entry point
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    TreasureChest chest = new TreasureChest();

    ItemIterator ringIterator = chest.iterator(ItemType.RING);
    while (ringIterator.hasNext()) {
      System.out.println(ringIterator.next());
    }

    System.out.println("----------");

    ItemIterator potionIterator = chest.iterator(ItemType.POTION);
    while (potionIterator.hasNext()) {
      System.out.println(potionIterator.next());
    }

    System.out.println("----------");

    ItemIterator weaponIterator = chest.iterator(ItemType.WEAPON);
    while (weaponIterator.hasNext()) {
      System.out.println(weaponIterator.next());
    }

    System.out.println("----------");

    ItemIterator it = chest.iterator(ItemType.ANY);
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

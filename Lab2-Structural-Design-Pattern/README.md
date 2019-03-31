# Structural Design Patterns
## Table of Contents
- [Adapter](#adapter)
- [Composite](#composite)
- [Decortor](#decorator)
- [Facade](#facade)

## Adapter <a name="adapter"></a>
An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".

In other words, to provide the interface according to client requirement while using the services of a class with a different interface.

The Adapter Pattern is also known as Wrapper.

- Bridge between 2 interfaces (Useful when we work with Legacy code)

### Disadvantages
- No new functionalities
- Multiple Adapters

## Composite <a name="composite"></a>

A Composite Pattern says that just "allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects".
The Composite pattern is used when we need a way to treat a whole group of objects in a similar, or the same manner.

This is usually done by the class that "owns" the group of objects and provides a set of methods to treat them equally as if they were a single object.

- Tree structure
- Component
- Leaf
- Composite

### Disadvantages
- Very costly to create more composite impl
- Overly simple

## Decorator <a name="decorator"></a>

The Decorator pattern is used to alter an individual instance of a class at runtime, by creating a decorator class which wraps the original class.

This way, changing or adding functionalities of the decorator object won't affect the structure or the functionalities of the original object.

It differs from classic inheritance in the fact that it's done at runtime, and applies only to an individual instance, whereas inheritance will affect all instances, and is done at compile time.

A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".

In other words, The Decorator Pattern uses composition instead of inheritance to extend the functionality of an object at runtime.

The Decorator Pattern is also known as Wrapper.

- Wrapper
- Add functionality or behavior
- Single Responsibility Principle
- Dynamically compose behavior
- Inheritance and Composition

## Disadvantages
- New Class for every feature
- no of objects (more)
- more comples for the clients

## Facade <a name="facade"></a>

The Facade pattern provides a simple and top-level interface for the client and allows it to access the system, without knowing any of the system logic and inner-workings.

A Facade Pattern says that just "just provide a unified and simplified interface to a set of interfaces in a subsystem, therefore it hides the complexities of the subsystem from the client".

In other words, Facade Pattern describes a higher-level interface that makes the sub-system easier to use.

Practically, every Abstract Factory is a type of Facade.

- Make API easy 
- Interface not required
- usually a refactoring pattern

## Disadvantages
- Over usage
- Clean up design pattern
# Creational Design Patterns
## Table of Contents
- [Singleton](#singleton)
- [Builder](#builder)
- [Factory](#factory)
- [AbstractFactory](#absfactory)

## Singleton <a name="singleton"></a>
Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
- Static in nature
- Thread safe
- Private Constructor
- Private Instance of the Class
- No parameters to the Constructor

### Disadvantages
- Overusage
- Unit testing
- Slow down
- Confused with factory design pattern (with arguments)

## Builder <a name="builder"></a>
Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.
- Solves the multiple constructor problem (telescoping constructors)
- static inner class (builder class)
- internally required constructor
- removes the need for setters

### Disadvantages
- Immutable
- inner static class
- Designed first
- Complex

## Factory <a name="factory"></a>
Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class. This pattern take out the responsibility of instantiation of a class from client program to the factory class.This pattern take out the responsibility of instantiation of a class from client program to the factory class. We can apply Singleton pattern on Factory class or make the factory method static.

- Doesn't expose instantiation or the creation logic
- Subclasses create the objects
- Common Abstract/Interface
- Framework, the client/ the implementation uses the factories

### Disadvantages
- Complex
- Creation in Subclasses
- Refactoring

## Abstract Factory <a name="absfactory"></a>
Abstract Factory pattern is similar to Factory pattern and it’s factory of factories. 
Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.
- Factory of factories/ related object / colelctions of factories
- Common Abstract/Interface
- Subclasses create the objects

### Disadvantages
- The code is complex
- Refactoring factory
- More control to client


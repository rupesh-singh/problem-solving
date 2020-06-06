Java Basic Revision

1. Introduction:

Main Features of Java:
    - Platform Independent
    - Multithreading
    - Robust (Garbage Collection & Exception handling)
    - Distributed

How Java Code executes ?
Java code => Java Compiler => Byte Code for VM => Java Interpreter => Machine code for Real Machine

Java Runtime Environment: (JRE)
    Combination of JVM and Java API

Java Runtime Area:
    1. Method Area => Actual code is stored in this area.
    2. Heap => Objects are created in this area.
    3. Stack => Area where execution os statement takes place.
    4. PC Registers => Stores the address of next instruction to be executed.


Data Types:

Primitives:
    1. Byte
    2. Short
    3. Int
    4. Long
    5. Float
    6. Double
    7. Char
    8. Boolean
    
Non-primitives:
    1. Classes
    2. Interfaces
    3. Arrays....


Integer Number System Supported by Java
    -> Decimal: Eg. int a=6; (0 to 9)
    -> Octal: Eg. int b = 010 (Value = 8 in decimal) (0 to 8)
    -> Hexadecimal: Eg. int b = 0X10 (16) (0 to F)
    -> Binary: Eg. int c = 0b10 

2. Java Operators and Command Line arguments

    => Arithmetic operators (+,-,/,*)
    => Bitwise Operators (&,|,^,~,>>,<<)
    => Logical Operators (&&,||,&,|, !)
    => Relational Opertaors (==, !=, >=, <=)

3. Java Classes and Objects

Objects has State and behaviour:
    State: (Variables)
        Type of variables
            1. Instance Variable : Variable of a Class (Created in heap)
            2. Local Variable: Variable local to a method (created in Stack)
            3. Reference Variable: variable referencing to an object
            4. Primitive variable: variable of type primitives
    
    Behaviour: (Methods)
        Access Modifiers:
            1. Public: Access Everywhere
            2. Private: Access only in the class
            3. Default: Access in same package (in same class and sub-classes)
            4. Protected: Access in same class and all its Subclasses (same and different package)

Encapsulation:
    Keep variables Private and methods public:

Passing Variables into methods:
    1. Passing primmitive Variables: 
        => Passing primitives is pass by value because here we are passing copy of object rather than actual object
    2. Passing Reference variables:
        => When we pass reference, we are not passing actual object rather a reference to that object. Also the reference is not the actual reference but the copy of the reference variable.
        => So we have 2 reference variables pointing to same object.

4. Java I/O and Arrays

5. Strings

6. Inheritance
    - Code reuseability 

Type of Inheritance in Java
    - Single Inheritance
    - Multilevel Inheritance
    - Hierarchical Inheritance

IS-A & HAS-A Relationship:
Association: Relationship between two seperate classes (Entities) 
    Aggretaion: Relationship in which both entities can survive independently. (White diamond)
    Composition: Entities cannot survive independently (black diamond)

Polymorphism:
    1. Static Polymorphism: Because it takes place at compile time. In static polymorphism, which method to call is decided at compile time based on type and number of arguments. 
        => Method Overloading
            Must Change argument list. Rest all optional
    2. Dynamic Polymorphism: It takes at runtime. As the method has same signature and return type, which method to call is decided at runtime based on type of object. As object is created at runtime, thus runtime polymorphism.
    Compiler checks for reference type. Jvm checks for object type
        => Method Overriding
           - Method Signature and return type must be same. Can change access modifier but make less restrictive (default => Protected => Public)
           - Reference data and types
           | reference  | object |      Data         |      Method       |
           |------------|--------|-------------------|-------------------|
           | super      | super  | super             | super             |
           | sub        | sub    | super + sub       | super + sub       |
           | sub        | sub    | overridden(sub)   | overridden(sub)   |
           | super      | sub    | super             | super             |
           | super      | sub    | overridden(super) | overridden(sub)   |
           - for Static data and method would always be of reference type.

7. Abstract & Interface

Abstract Classes
    => Used to declare common characteristics of classes
    => Keyword abstract

Interface
    => class that contains all the methods which are abstract.
    => Advantage of interface is that it enables Multiple Inheritance




 
# Flight Simulation
Simple project to demonstrate the application of OOP concepts in flight simulation.

This project can only be used for educational purposes and it needs changes to be optimized for its use in other fields.
## Idea description
This project is about simulating of flight and aircraft which have some basic entities listed below:
1. Aircraft
2. Map
3. Watchtower
4. Navigator

In the above we have `Aircraft` and `Watchtower` which can be many in the real world so I decided to implement it as a class that can 
be instantiated but it is the opposite for `Map` so Map is a class that cannot be instantiated and There is only one object in the 
entire program of it.
In this project i tried to implement all the OOP Concepts such as Modularity, hierarchy, composition, reuse, encapsulation, subtyping, 
information hiding, abstraction, inheritance, polymorphism and exception handling and i'd like to show how i implemented each of them 
but before to dive into the detail i tend to explain about Graphic User interface.



# GUI
After write some piece of code about this simulation i found out that  it can not be represented as a simple command line application 
so i tried to implement a user interface use JavaSwing which i had worked with it already.
I started to show and control a simple rectangle using keyboard. i tried to use OOP concepts, after i implemented some of the codes, it 
was amazingly easy to add new features to the simulation, and with a little thought, i could add interesting things to my codes without 
complications hence i understood the power of OOP and i enjoyed a lot.
to implement the GUI i had to use Thread and implement a class which refresh the screen every 60 ms.
as I have some experience in UI designing too i started to design a beautiful UI and this was the result of my attempt.

![](https://github.com/dalmif/FlightSimulation/blob/main/screenshot/scrren_shot.gif?raw=true)



# Story begins
but what is the story of this?
in this version we just have one aircraft in the map which can be controlled. 
the aircraft will request to the nearest `Watchtower` and if the tower accept, the connection will be established and aircraft send a 
disconnect signal to the previous connected tower.
we have an Aircraft entity which define the general attributes and a `ControllableAircraft` that can fly and be controlled by our 
keyboard also can be drawn on the screen.
now we can implement variety of aircraft such as Military and Airliner and subtype of both.


![](https://github.com/dalmif/FlightSimulation/blob/main/screenshot/hierarchy1.png?raw=true)
(Purple shows Abstract)

This is the hierarchy of Aircrafts.
but it's not complete hierarchy and there are some interfaces which are implemented by them such as `Controllable` and `Drawable` that 
i explain below.
* *Controllable*: is used for the entities who fly in the sky and have 2 main functions which are `move()` and `useFuel()` which 
ControllableAircraft implemented them.
* *Drawable*: the element which has an image to be drawn on the screen like Watchtower and ControllableAircraft.

here is the complete hierarchy.
![](https://github.com/dalmif/FlightSimulation/blob/main/screenshot/hierarchy2.png?raw=true)
(Green shows Interface)

and the last episode of the story is Weapons which are simple and not powerful in this version.
a `MilitaryAircraft`  can have some `Weapons` and each weapon has special Key to fire and also has a destruction power which 
demonstrate the power of a weapon.



# OOP Concepts used
this part of this report file will evaluate the usage of concepts.

### Modularity
The project has divide it's files to multiple packages with related classes such as Unit, Utility and Weapons which can be reused in 
other project in the future.


### Hierarchy
the main entity is Aircraft which is implemented with the main attributes like
```java
private String model;  
private int maximumSpeed;  
private int minimumSpeed;  
private int fuelCapacity;
```
and other functionality and attributes related to each model and aircraft are implemented by inheritance of this class. so there is a 
Hierarchy which the root is this `Aircraft` class.
the graph of this Hierarchy has been shown in top.

### Composition
composition is one of the concept which is widely used in this project for example each `ControllableAircraft` has a `Navigator` to 
find the nearest Watchtower.
```java
private Coordination coordination;
private Watchtower watchtower;
private final Navigator navigation;
```
all of these classes have their own implementation but they compose together to make a complex class which work together.
another example is `MilitaryAircraft` which has multiple Weapons
```java
private Weapon[] weapons;
```


### Reuse
Writing Reusable code is a good practice and this concept is one of the most important concepts in OOP.
in this project i use a variety of reusing for example extending `Aircraft` in other classes
for example in this piece of code:
```java
public class BusinessJet extends Airliner {
   ...
}
```
actually with this code i reuse all of the properties of `Airliner` without copy-pasting.
in a deep looking we can use functionality of Airliner such as refill the tank or navigation system in BusinessJet without any further 
code

### Encapsulation
When we write code that another programmer might want to work on, encapsulation plays an important role in preventing unwanted access. 
it can be critical for any medium and big scale project.
for instance, in this project  `setRemainingFuel` function should be inaccessible outside of the `Aircraft` class (but should be 
accessible in derived classes) so i think protected access modifier is suitable.
```java
protected void setRemainFuel(float fuel) {  
	... 
}
```

and also there are many functions and attributes that should be accessible only in the file.
```java
private void draw(Drawable drawable) {  
	...
}
```



### Subtyping
in this project we have some interface and abstract class which other related class implemented them.
for example there is a `Drawable` interface which requires any class that wants to implement it to specify the image and location of 
the image to be drawn.
ControllableAircraft can be a good example
```java
public abstract class ControllableAircraft extends Aircraft implements Controllable, Connectable, Drawable {
...
}
```
as you see there are other interfaces which ControllableAircraft is also subtype of them.
`Controllable` is an interface which have two abstract functions `move()` and `useFuel()` that `ControllableAircraft` implemented it.


### Information hiding
many of attributes should not be accessible directly because may something need to be checked before assignment or it can cause other 
problems then we prefer to write the attributes with private access modifier and use Setter and Getter.
in the project there are a lot of attributes which are privates but can be accessible using setter and getter like the following 
example
```java
private int combatRange;
public int getCombatRange() {  
	return combatRange;  
}  
  
public void setCombatRange(int combatRange) {  
	this.combatRange = combatRange;  
}
```

abstraction and interfaces can be another kind of information hiding because they are also hide the implementation and other classes 
can interact with the abstraction without needing to know the internal workings of the object.

### Abstraction
abstraction help us to generalize many concept and entities. we just use the functions without knowing the implementation behind it.
this project uses multi level of abstraction the root level is `Aircraft` which abstract the main attributes and functionality and in 
the upper layers we have `MultiMilitaryAircraft` and `ControllableAircraft` which inherited from `ControllableAircraft` and they are a 
layer for `BusinessJet` and `CommercialAirliner` and `FighterJet`.
you can see the Abstract classes and interface in the above graph.
here is an example of an abstract class which is inherited from `ControllableAircraft`
```java
public abstract class Airliner extends ControllableAircraft {
...
}
```


### Inheritance
we discuss about inheritance in the other subjects such as Hierarchy and reuse but if we want to tell more about it we can say this is 
a powerful concept that i use a lot in this project.
when we inherit a class we can use it as the subclass that is very helpful in polymorphism, which means objects of derived classes can 
be treated as objects of their base class. This enables writing generic code that can work with different types of objects, providing 
flexibility and extensibility. we discuss about polymorphism and its example in the next section but now let me show you some examples 
of Inheritance.

```java
public abstract class MilitaryAircraft extends ControllableAircraft
```
the `MilitaryAircraft` class extends from a class called `ControllableAircraft` which means the `MilitaryAircraft` now is a 
`ControllableAircraft` too.
it have all of the functionality of its father.


### Polymorphism
Polymorphism is complementary of other OOP Concept it's very important.
it has several kind which i use 3 of them.
the first one (1) is when i use the object as its subclass or subtype like `FighterJet` that i instantiate it and assign to a variable 
with `ControllableAircraft` type.
here is an example.
```java
private static ControllableAircraft createAircraft () {  
    return new CommercialAirliner("F41", 300, 150, 200, "Mohammad", 110, 90, 500, 200);
}
```
the second one (2) is when i use the same name for two function but the correct one will be used depend on the signature of function.
```java
private void draw(String text){
	...
}
private void draw(Drawable drawable) {  
	...  
}
```

finally third one (3) is when in a part of code we have `ArrayList<String> details = map.getMyAircraft().getInformation();` which call 
a function of `Aircraft` named `getInformation()` that is a function that any derived class override it and add its information so the 
returned value can be different depend on the object stored in `Aircraft myAircraft;`

### Exception handling
Exceptions are so useful specially if you code in some languages like C which has no mechanism for Exception handling.
They help us to write more readable and debuggable code.
I used both `RuntimeException` and `Exception` in different situation. 
when a `Connectable` entity like `ControllableAircraft` become near to a `Wathctower` a connection request will be send to the tower 
and the tower can decide whether `accept` or throw an Exception depend on the capacity so the function which send this request has a 
try/catch to handle this exception 
```java
try {  
    nearestTower.connectionRequest(this);  
} catch (Exception e) {  
	System.out.println("please try again later");
    System.out.println(e.getMessage());  
}
```

the second example is about `RunetimeException` in the `setMinimumSpeed()` that will be thrown if the parameter of minimum speed for 
the aircraft is lower than 150 mph. (it should not be caught because if the programmer sets the min speed incorrectly when 
instantiating, the app will have to crash to tell him the correct value)
```java
if (minSpeed < DEMONSTRATION_SPEED || minSpeed > DEMONSTRATION_SPEED * 2) {  
    throw new RuntimeException("You just can set maximum between " + DEMONSTRATION_SPEED + ", " + DEMONSTRATION_SPEED * 2);  
}
```


The End

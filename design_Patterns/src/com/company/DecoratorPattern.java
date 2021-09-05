package com.company;

public class DecoratorPattern {
  public static void main(String[] args) {
    PeppyPaneer peppyPaneer = new PeppyPaneer();
    Cheese cheese1 = new Cheese(peppyPaneer);
    Cheese cheese2 = new Cheese(peppyPaneer);
    Pepperoni pepperoni = new Pepperoni(peppyPaneer);
    System.out.println(
        peppyPaneer.getCost()
            + " "
            + cheese1.getCost()
            + " "
            + cheese2.getCost()
            + " "
            + pepperoni.getCost());
  }
}

abstract class toppings {}

class Margherita extends basePizza {
  public Margherita() {
    super("Margherita", 150);
  }
}

class Mexican extends basePizza {
  public Mexican() {
    super("Mexican", 130);
  }
}

class PeppyPaneer extends basePizza {
  public PeppyPaneer() {
    super("Mexican", 230);
  }
}

class Jalapeno extends toppings {
  basePizza pizza;

  public Jalapeno(basePizza basePizza) {
    this.pizza = basePizza;
  }

  public int getCost() {
    return this.pizza.getCost() + 20;
  }
}

class Pepperoni extends toppings {
  basePizza pizza;

  public Pepperoni(basePizza basePizza) {
    this.pizza = basePizza;
  }

  public int getCost() {
    return this.pizza.getCost() + 50;
  }
}

class Cheese extends toppings {
  basePizza pizza;

  public Cheese(basePizza basePizza) {
    this.pizza = basePizza;
  }

  public int getCost() {
    return this.pizza.getCost() + 10;
  }
}

abstract class basePizza {
  String pizza;
  private int price;

  public basePizza(String pizza, int price) {
    this.pizza = pizza;
    this.price = price;
  }

  public int getCost() {
    return this.price;
  }
}

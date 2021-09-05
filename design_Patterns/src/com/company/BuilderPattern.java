/*
    Consider pizza comes in various toppings.
    Pizza(int size)
    Pizza(int size, boolean cheese)
    Pizza(int size, boolean cheese, boolean pepperoni)
    Pizza(int size, boolean cheese, boolean pepperoni, boolean jalapeno)
    Pizza(int size, boolean cheese, boolean pepperoni, boolean jalapeno, ......)

    This is called telescopic constructors.

    Pizza pizza = new Pizza(8);
    pizza.setCheese(true);
    pizza.setJalapeno(true);
    pizza.setPeperoni(true);

    This is called JavaBeans pattern.

    But here it can become inconsistent partway into building pizza.

    Pizza should not be made until it validates all the inputs. So no wastage of pizza!

*/

package com.company;

public class BuilderPattern {
  public static void main(String[] args) {
    Pizza pizza = new Pizza.Builder().setCheese(true).setJalapeno(true).setPepperoni(false).build();
  }
}

class Pizza {
  int size;
  boolean pepperoni;
  boolean jalapeno;
  boolean cheese;

  private Pizza(Builder builder) {
    this.size = builder.size;
    this.cheese = builder.cheese;
    this.jalapeno = builder.jalapeno;
    this.pepperoni = builder.pepperoni;
  }

  static class Builder {
    private int size;
    private boolean pepperoni;
    private boolean jalapeno;
    private boolean cheese;

    public Builder setSize(int size) {
      this.size = size;
      return this;
    }

    public Builder setCheese(boolean cheese) {
      this.cheese = cheese;
      return this;
    }

    public Builder setPepperoni(boolean pepperoni) {
      this.pepperoni = pepperoni;
      return this;
    }

    public Builder setJalapeno(boolean jalapeno) {
      this.jalapeno = jalapeno;
      return this;
    }

    public Pizza build() {
      return new Pizza(this);
    }
  }
}

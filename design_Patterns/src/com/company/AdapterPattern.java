/*
    You have interface with basic behaviour which can be
    implemented and used as required.

    Does not add behaviour in anyway. Modifies existing interface to allow some other class to use
    existing functionality.
    If the need is for adding new behaviour then we use strategy Pattern.
*/

package com.company;

interface shape {
  public int calculateArea(int r);
}

public class AdapterPattern {
  public static void main(String[] args) {

    CircleAdapter circleAdapter = new CircleAdapter();
    SquareAdapter squareAdapter = new SquareAdapter();

    System.out.println(
        "Area of circle: "
            + circleAdapter.calculateArea(3)
            + " "
            + "Area of square: "
            + squareAdapter.calculateArea(3));

  }
}

class SquareAdapter implements shape {
  @Override
  public int calculateArea(int r) {
    return r * r;
  }
}

class CircleAdapter implements shape {
  @Override
  public int calculateArea(int r) {
    return (int) (3.14 * r * r);
  }
}

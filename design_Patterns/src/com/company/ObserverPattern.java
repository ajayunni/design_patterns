/*
    Steps:
        1. Observer pattern requires Observable (cow) and Observer (farmer)
        2. Observable performs action and does setChanged(); It is like committing all the changes.
        3. Pushing the changes to all the Observers using notifyObservers();
        4. Observer will get registered to Observable using .addObserver();

    Cons:
        1. Doesn't keep track of what changed. Will have to pass via obj in notifyObservers(arg);
        2. Any Observer can observe any Observables.

*/

package com.company;

import java.util.Observable;

public class ObserverPattern {

  public static void main(String[] args) {
    Cow cow = new Cow();
    Watcher farmer = new Watcher();
    cow.addObserver(farmer);
    cow.speak();
  }
}

class Watcher implements java.util.Observer {
  @Override
  public void update(Observable o, Object arg) {
    System.out.println(arg);
  }
}

class Cow extends Mammal {
  @Override
  public String getName() {
    return "cow";
  }

  @Override
  public void speak() {
    super.speak();
  }
}

class Mammal extends Observable {
  public String getName() {
    return "Mammal";
  }

  public void speak() {
    setChanged();
    notifyObservers("Mooooo!");
  }
}

package com.company;

import java.util.HashSet;
import java.util.Set;

public class StatePattern {
  public static void main(String[] args) {
    WashingMachine washingMachine = new WashingMachine();
    System.out.println("State is now " + washingMachine.getState());
    washingMachine.openLid();
    System.out.println("State is now " + washingMachine.getState());
    washingMachine.Wash();
    System.out.println("State is now " + washingMachine.getState());
    washingMachine.CloseLid();
    System.out.println("State is now " + washingMachine.getState());
    washingMachine.Wash();
    System.out.println("State is now " + washingMachine.getState());
  }
}

class WashingMachineState {
  String state;

  public WashingMachineState(String state) {
    this.state = state;
  }

  public boolean changeState(WashingMachineState washingMachineState) {
    return true;
  }
}

class OpenLid extends WashingMachineState {
  Set<String> allowedStates;

  public OpenLid() {
    super("openLid");
    allowedStates = new HashSet<>();
    allowedStates.add(("closeLid"));
  }

  @Override
  public boolean changeState(WashingMachineState washingMachineState) {
    if (!allowedStates.contains(washingMachineState.state)) {
      System.out.println(
          washingMachineState.state + " NOT allowed while machine is in " + this.state);
      return false;
    } else this.state = washingMachineState.state;
    return true;
  }
}

class CloseLid extends WashingMachineState {
  Set<String> allowedStates;

  public CloseLid() {
    super("closeLid");
    allowedStates = new HashSet<>();
    allowedStates.add(("openLid"));
    allowedStates.add(("washing"));
  }

  @Override
  public boolean changeState(WashingMachineState washingMachineState) {
    if (!allowedStates.contains(washingMachineState.state)) {
      System.out.println(
          washingMachineState.state + " NOT allowed while machine is in " + this.state);
      return false;
    } else this.state = washingMachineState.state;
    return true;
  }
}

class Idle extends WashingMachineState {
  Set<String> allowedStates;

  public Idle() {
    super("idle");
    allowedStates = new HashSet<>();
    allowedStates.add(("openLid"));
    allowedStates.add(("closeLid"));
    allowedStates.add(("washing"));
  }

  @Override
  public boolean changeState(WashingMachineState washingMachineState) {
    if (!allowedStates.contains(washingMachineState.state)) {
      System.out.println(
          washingMachineState.state + " NOT allowed while machine is in " + this.state);
      return false;
    } else this.state = washingMachineState.state;
    return true;
  }
}

class Washing extends WashingMachineState {
  Set<WashingMachineState> allowedStates;

  public Washing() {
    super("washing");
    allowedStates = new HashSet<>();
    allowedStates.add(new WashingMachineState("idle"));
  }

  @Override
  public boolean changeState(WashingMachineState washingMachineState) {
    if (!allowedStates.contains(washingMachineState)) {
      System.out.println(
          washingMachineState.state + " NOT allowed while machine is in " + this.state);
      return false;
    } else this.state = washingMachineState.state;
    return true;
  }
}

class WashingMachine {

  private WashingMachineState state;

  public WashingMachine() {
    this.state = new Idle();
  }

  private boolean changeState(WashingMachineState state) {
    return this.state.changeState(state);
  }

  public boolean openLid() {
    if (changeState(new WashingMachineState("openLid"))) {
      this.state = new OpenLid();
      return true;
    }
    return false;
  }

  public boolean CloseLid() {
    if (changeState(new WashingMachineState("closeLid"))) {
      this.state = new CloseLid();
      return true;
    }
    return false;
  }

  public boolean Wash() {
    if (changeState(new WashingMachineState("washing"))) {
      this.state = new Washing();
      return true;
    }
    return false;
  }

  public boolean Idle() {
    if (changeState(new WashingMachineState("idle"))) {
      this.state = new Idle();
      return true;
    }
    return false;
  }

  public String getState() {
    return state.state;
  }
}

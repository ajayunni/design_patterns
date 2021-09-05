package com.company;

public class FactoryPattern {
  public static void main(String[] args) {
    House house = new House();
    System.out.println(house.toString());
  }
}

class BathRoom {
  Shower shower;
  Toilet toilet;

  public BathRoom() {
    this.shower = new Shower();
    this.toilet = new Toilet();
  }

  @Override
  public String toString() {
    return "BathRoom{" + "shower=" + shower + ", toilet=" + toilet + '}';
  }
}

class Toilet {
  @Override
  public String toString() {
    return "Toilet{}";
  }
}

class Shower {
  @Override
  public String toString() {
    return "Shower{}";
  }
}

class Kitchen {
  Sink sink;
  Pipes pipes;

  public Kitchen() {
    this.sink = new Sink();
    this.pipes = new Pipes();
  }

  @Override
  public String toString() {
    return "Kitchen{" + "sink=" + sink + ", pipes=" + pipes + '}';
  }
}

class Pipes {
  @Override
  public String toString() {
    return "Pipes{}";
  }
}

class Sink {
  @Override
  public String toString() {
    return "Sink{}";
  }
}

class BedRoom {
  Bed bed;
  Mattress mattress;

  public BedRoom() {
    this.bed = new Bed();
    this.mattress = new Mattress();
  }

  @Override
  public String toString() {
    return "BedRoom{" + "bed=" + bed + ", mattress=" + mattress + '}';
  }
}

class Bed {
  @Override
  public String toString() {
    return "Bed{}";
  }
}

class Mattress {
  @Override
  public String toString() {
    return "Mattress{}";
  }
}

class House {
  BedRoom bedRoom;
  Kitchen kitchen;
  BathRoom bathRoom;

  public House() {
    this.bedRoom = new BedRoom();
    this.kitchen = new Kitchen();
    this.bathRoom = new BathRoom();
  }

  @Override
  public String toString() {
    return "House{"
        + "bedRoom="
        + bedRoom
        + ", kitchen="
        + kitchen
        + ", bathRoom="
        + bathRoom
        + '}';
  }
}

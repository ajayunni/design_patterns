package com.company;

public class SingletonPattern {
  public static void main(String[] args) {
    Log log = Log.getLog();
    Log log2 = Log.getLog();
    Log log3 = Log.getLog();
    Log log4 = Log.getLog();


  }
}

class Log {
  private static final Log log = new Log();
  int val;

  private Log(){}

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public static Log getLog() {
    return log;
  }
}

/*
Strategy pattern encapsulates different behaviour and allows to be switched during run time.
 */

package com.company;

interface Sort {
  public void doSort(int[] arr);
}

public class strategyPattern {
  public static void main(String[] args) {
    Sorter sorter = new Sorter(new quickSort());
    sorter.sort.doSort(new int[] {1, 2, 3});
  }
}

class Sorter {
  Sort sort;

  public Sorter(Sort sort) {
    this.sort = sort;
  }
}

class bubbleSort implements Sort {

  @Override
  public void doSort(int[] arr) {
    //
  }
}

class mergeSort implements Sort {

  @Override
  public void doSort(int[] arr) {
    //
  }
}

class quickSort implements Sort {

  @Override
  public void doSort(int[] arr) {
    //
  }
}

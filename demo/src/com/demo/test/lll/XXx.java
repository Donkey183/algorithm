package com.demo.test.lll;

import java.util.Deque;
import java.util.LinkedList;

public class XXx {

  public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();
    deque.offerFirst(1);
    deque.offerFirst(2);
    deque.offerFirst(3);
    deque.offerFirst(4);

    while (!deque.isEmpty()) {
      System.out.println("Deque:" + deque.poll());
    }
  }


}

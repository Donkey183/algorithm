package com.demo.test.lll;

import java.util.Stack;

public class 两个栈实现队列 {


  public static class MyQueue {

    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void put(int i) {
      stack1.push(i);
    }

    public int poll() {
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      return (int) stack2.pop();
    }
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.put(1);
    queue.put(2);
    queue.put(3);
    System.out.println(queue.poll());
    queue.put(4);
    queue.put(5);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    queue.put(6);
    queue.put(7);
    queue.put(8);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
  }
}

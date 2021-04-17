package com.demo.test.ll;

import java.util.ArrayList;
import java.util.List;

public class ImplementQueueWithFixedSizeofArrays {
  public class QueueWithFixedArray {
    private int fixedSize;
    private int count;
    private int head;
    private int tail;
    private List<Object> headList;
    private List<Object> tailList;
    
    public QueueWithFixedArray(int fixedSize) {
      this.fixedSize = fixedSize;
      this.count = 0;
      this.head = 0;
      this.tail = 0;
      this.headList = new ArrayList<>();
      this.tailList = this.headList;
    }
    
    public void offer(int num) {
      if (tail == fixedSize - 1) {
        List<Object> newList = new ArrayList<>();
        newList.add(num);
        tailList.add(newList);
        tailList = (List<Object>) tailList.get(tail);
        tail = 0;
      } else {
        tailList.add(num);
      }
      count++;
      tail++;
    }
    
    public Integer poll() {
      if (count == 0) {
        return null;
      }
      
      int num = (int) headList.get(head);
      head++;
      count--;
      
      if (head == fixedSize - 1) {
        List<Object> newList = (List<Object>) headList.get(head);
        headList.clear();
        headList = newList;
        head = 0;
      }
      
      return num;
    }
    
    public int size() {
      return count;
    }
  }
  
  /**
   * Implement a queue with a number of arrays, in which each array has fixed size.
   *
   * @param args
   */
  public static void main(String[] args) {
    QueueWithFixedArray queue = new ImplementQueueWithFixedSizeofArrays().new QueueWithFixedArray(5);
    queue.offer(1);
    queue.offer(2);
//    System.out.println("=====poll=====" + queue.poll());
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    queue.offer(6);
    queue.offer(7);
//    System.out.println("=====poll=====" + queue.poll());
    queue.offer(8);
    queue.offer(9);

    queue.offer(10);
    queue.offer(11);
    queue.offer(12);
    queue.offer(13);
    queue.offer(14);
    queue.offer(15);
    queue.offer(16);
    queue.offer(17);
    queue.offer(18);
    queue.offer(19);
    queue.offer(20);

    System.out.println("=====poll=====" + queue.poll());
    System.out.println("=====poll=====" + queue.poll());
    System.out.println("=====poll=====" + queue.poll());
    System.out.println("=====poll=====" + queue.poll());
    System.out.println("=====poll=====" + queue.poll());
  }
}

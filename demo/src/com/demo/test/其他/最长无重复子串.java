package com.demo.test.其他;

import java.util.LinkedList;
import java.util.Queue;

public class 最长无重复子串 {

  public static void main(String[] args) {
    System.out.println("Result=" + maxLength2("abcdddabcde"));
  }

  public static int maxLength(int[] arr) {
    //用链表实现队列，队列是先进先出的
    Queue<Integer> queue = new LinkedList<>();
    int maxLen = 0;
    for (int c : arr) {
      while (queue.contains(c)) {
        //如果有重复的，队头出队
        queue.poll();
      }
      //添加到队尾
      queue.add(c);
      maxLen = Math.max(maxLen, queue.size());
    }
    return maxLen;
  }


  public static int maxLength2(String s) {
    if (s == null || s.length() <= 0) {
      return 0;
    }
    //用链表实现队列，队列是先进先出的
    Queue<Character> queue = new LinkedList<>();
    int res = 0;
    for (Character c : s.toCharArray()) {
      while (queue.contains(c)) {
        //如果有重复的，队头出队
        queue.poll();
      }
      //添加到队尾
      queue.add(c);
      res = Math.max(res, queue.size());
    }
    return res;
  }
}

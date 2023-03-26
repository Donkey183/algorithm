package com.demo.test.其他;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 数组中最小或最大K个数 {

  public static void main(String[] args) {
    int[] arrays = new int[]{99, 66, 77, 22, 1, 9, 7, 2, 3, 8, 5, 10, 33};
    topK(arrays, 5);
  }

  private static void topK(int[] arrays, int K) {
    Queue<Integer> queue = new PriorityQueue<>(K, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1; // 由小到大顺序存储，若o1 - o2则为由大到小存储， 默认是从小到大
      }
    });
    for (int i = 0; i < arrays.length; i++) {
      if (queue.size() >= K) {
        int tmp = queue.poll();
        // 若输出最大K个数则 tmp = arrays[i] < tmp ? tmp : arrays[i];
        tmp = arrays[i] > tmp ? tmp : arrays[i];
        queue.add(tmp);
      } else {
        queue.add(arrays[i]);
      }
    }
    while (!queue.isEmpty()) {
      System.out.println(queue.poll());
    }
  }
}
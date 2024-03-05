package com.demo.test.airbnb面试算法;

import java.util.*;

public class RoundNums {
  /**
   * When you book on airbnb the total price is:
   * <p>
   * Total price = base price + service fee + cleaning fee + …
   * input : array of decimals ~ X
   * output : array of int ~ Y
   * sum(Y) = round(sum(x))
   * minmize (|y1-x1| + |y2-x2| + ... + |yn-xn|)
   * Example1:
   * input = 30.3, 2.4, 3.5
   * output = 30 2 4
   * <p>
   * Example2:
   * input = 30.9, 2.4, 3.9
   * output = 31 2 4
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] round1 = round(new double[]{30.3d, 2.4d, 3.5d, 5.1d, 6.6d});
    int[] round2 = round(new double[]{30.9d, 2.4d, 3.9d});
    for (int i : round1) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : round2) {
      System.out.print(i + " ");
    }
  }

  /**
   * 思路：
   * Step1: 将所有double类型的价格加入优先级队列，使得小数点越大的数排在队列头部，并且使用一个新的数组存储int价格(向下取整)
   * Step2: 求和，算出double类型价格总和、int(向下取整)类型价格总和
   * Step3: 计算double价格总和以及int类型总和相差数(可以给你多少个价格执行+1)
   * Step4: 遍历优先级队列，执行加价操作
   */
  public static int[] round(double[] candicates) {
    Queue<Double> queue = new PriorityQueue<Double>(new Comparator<Double>() {
      @Override
      public int compare(Double x, Double y) {
        // 将小数点背后大的放前面
        int result = Double.compare(Math.ceil(x) - x, Math.ceil(y) - y);
        return result;
      }
    });
    double doubleSum = 0d;
    int intSum = 0;
    int[] res = new int[candicates.length];
    for (int i = 0; i < candicates.length; i++) {  // 遍历入队以及double求和，int求和
      doubleSum += candicates[i];
      intSum += Math.floor(candicates[i]);
      queue.offer(candicates[i]);
      res[i] = (int) Math.floor(candicates[i]);
    }
    int offset = (int) (doubleSum - intSum); // 求最多可加多少个
    for (int i = 0; i < offset; i++) {
      double tmp = queue.poll();
      for (int j = 0; j < candicates.length; j++) {
        if (tmp == candicates[j]) {
          res[j] += 1;
          break;
        }
      }
    }
    return res;
  }
}

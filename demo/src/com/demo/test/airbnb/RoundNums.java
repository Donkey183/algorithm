package com.demo.test.airbnb;

import java.util.*;

public class RoundNums {
  
  public static int[] round(double[] input) {
    if (input == null || input.length == 0) {
      return new int[0];
    }
    Queue<Double> minCeil = new PriorityQueue<Double>(input.length, new Comparator<Double>() {
      public int compare(Double x, Double y) {
        return Double.compare(Math.ceil(x) - x, Math.ceil(y) - y);
      }
    });
    Double sum = 0.0;
    int floorSum = 0;
    int[] res = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      sum += input[i];
      int floor = (int) Math.floor(input[i]);
      floorSum += floor;
      res[i] = floor;
      minCeil.add(input[i]);
    }
    int offset = (int) Math.round(sum) - floorSum;
    Set<Double> mins = new HashSet<>();
    for (int i = 0; i < offset; i++) {
      mins.add(minCeil.poll());
    }
    for (int i = 0; i < res.length && offset > 0; i++) {
      if (mins.contains(input[i])) {
        res[i]++;
        offset--;
      }
    }
    return res;
  }
  
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
    int[] round1 = xxx(new double[]{30.3d, 2.4d, 3.5d});
    int[] round2 = xxx(new double[]{30.9d, 2.4d, 3.9d});
    for (int i : round1) {
      System.out.print(i + " ");
    }
    System.out.println();
    for (int i : round2) {
      System.out.print(i + " ");
    }
  }
  
  public static int[] xxx(double[] candicates) {
    Queue<Double> queue = new PriorityQueue<Double>(new Comparator<Double>() {
      @Override
      public int compare(Double x, Double y) {
        return Double.compare(Math.ceil(x) - x, Math.ceil(y) - y);
      }
    });
    double doubleSum = 0d;
    int intSum = 0;
    int[] res = new int[candicates.length];
    for (int i = 0; i < candicates.length; i++) {
      doubleSum += candicates[i];
      intSum += Math.floor(candicates[i]);
      queue.offer(candicates[i]);
      res[i] = (int) Math.floor(candicates[i]);
    }
    int offset = (int) (doubleSum - intSum);
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

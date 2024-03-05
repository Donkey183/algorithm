package com.demo.test.airbnb面试算法;

public class MaxNights {

  public static int findMaxDays(int[] days, int i) {
    if (i == days.length - 1) {
      return days[days.length - 1];
    }
    if (i > days.length - 1) {
      return 0;
    }
    return Math.max(days[i] + findMaxDays(days, i + 2), days[i] + findMaxDays(days, i + 3));
  }

  /**
   * Provide a set of positive integers (an array of integers ). Each integer represent number of
   * nights user request on Airbnb.com. If you are a host, you need to design and implement an
   * algorithm to find out the maximum number a nights you can accommodate. The constrain is that
   * you have to reserve at least one day between each request, so that you have time to clean the
   * room. Example: 1) Input: [1, 2, 3] ===&gt; output: 4, because you will pick 1 and 3 2)input:
   * [5, 1, 2, 6] ===&gt; output: 11, because you will pick 5 and 6 3)input: [5, 1, 2, 6, 20, 2]
   * ===&gt; output: 27, because you will pick 5, 2, 20
   */
  public static void main(String[] args) {
    int[] one = {1, 2, 3};
    int[] two = {5, 1, 2, 6};
    int[] three = {5, 1, 2, 6, 20, 2};
    System.out.println(findMaxDays(one, 0));
    System.out.println(findMaxDays(two, 0));
    System.out.println(findMaxDays(three, 0));
  }
}

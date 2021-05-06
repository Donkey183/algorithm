package com.demo.test.lll;

import java.util.ArrayList;
import java.util.Arrays;

public class 最小的K个数 {


  public static ArrayList<Integer> getKMinNum(int[] input, int k) {
    ArrayList<Integer> result = new ArrayList<>();
    if (input == null || input.length == 0 || input.length < k) {
      return result;
    }
    Arrays.sort(input);
    for (int i = 0; i < k; i++) {
      result.add(input[i]);
    }
    return result;
  }


  public static void main(String[] args) {
    int[] input = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
    ArrayList<Integer> result = getKMinNum(input, 4);
    for (Integer integer : result) {
      System.out.println(integer);
    }
  }
}

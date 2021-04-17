package com.demo.test.lll;

public class MaxSubsequenceSum {
  public static void main(String[] args) {
    int a[] = {2, 11, 8, -4, -1, -16, 5, 0};
    System.out.print("====result===" + maxSubsequenceSum(a));
  }
  
  public static int maxSubsequenceSum(int[] a) {
    int maxSum = 0, thisSum = 0;
    for (int i = 0; i < a.length; i++) {
      thisSum += a[i];
      if (thisSum > maxSum) {
        maxSum = thisSum;
      }
      if (thisSum < 0) {
        thisSum = 0;
      }
    }
    return maxSum;
  }
}

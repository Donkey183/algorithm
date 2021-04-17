package com.demo.test.lll;

import java.util.Arrays;

public class Puke {
  /**
   *
   * @param a
   * @return
   */
  public static boolean judge(int[] a)  //解法一
  {
    Arrays.sort(a);
    int zeroNum = a[0] == 0 ? a[1] == 0 ? 2 : 1 : 0;
    for (int i = a.length - 1; i >= zeroNum; i--) {
      if (a[i] - a[i - 1] > zeroNum + 1 || a[i] == a[i - 1] || zeroNum < 0) {
        return false;
      } else if (a[i] - a[i - 1] > 1) {
        zeroNum -= a[1] - a[i - 1];
      }
    }
    return true;
  }
  
  /**
   * 判断五张牌是否是顺子
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] a = new int[]{2, 3, 0, 7, 0};
    System.out.println(judge(a));
  }
}

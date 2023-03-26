package com.demo.test.其他;

public class 符串S在T中出现的次数 {

  public static void main(String[] args) {
    System.out.println("Result=" + kmp("abab", "abababab"));
  }

  /**
   * 计算字符串S在T中出现的次数
   */
  public static int kmp(String S, String T) {
    if (S == null || T == null || S.length() > T.length()) {
      return 0;
    }
    int sLen = S.length();
    int tLen = T.length();
    int count = 0;
    for (int i = 0; i <= tLen - sLen; i++) {
      if (tLen >= i + sLen) {
        String tmp = T.substring(i, i + sLen);
        if (tmp.equals(S)) {
          count++;
        }
      }
    }
    return count;
  }
}

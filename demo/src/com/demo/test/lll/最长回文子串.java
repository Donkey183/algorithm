package com.demo.test.lll;

public class 最长回文子串 {

  //
  public static void main(String[] args) {
    System.out.println("isPalindrome:" + isPalindrome("abcdcba"));
    System.out.println("getLongestPalindrome:" + getLongestPalindrome("abba"));
  }

  public static int getLongestPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String tmp = s.substring(i, j);
        if (isPalindrome(tmp)) {
          max = Math.max(max, j - i);
        }
      }
    }

    return max;
  }

  public static boolean isPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return false;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }
    return true;
  }
}

package com.demo.test.ll;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {
  private static boolean isPalindrome(String str) {
    if (str == null || str.length() <= 2) {
      return false;
    }
    char charArray[] = str.toCharArray();
    int left = 0;
    int right = charArray.length - 1;
    while (left < right) {
      if (charArray[left] != charArray[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
  
  private static List<List<Integer>> test(String strs[]) {
    List<List<Integer>> result = new ArrayList<>();
    if (strs == null || strs.length <= 0) {
      return result;
    }
    for (int i = 0; i < strs.length; i++) {
      for (int j = 0; j < strs.length; j++) {
        if (isPalindrome(strs[i] + strs[j])) {
          List<Integer> list = new ArrayList<>();
          list.add(i);
          list.add(j);
          result.add(list);
        }
      }
    }
    return result;
  }
  
  /**
   * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
   * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
   */
  
  public static void main(String[] args) {
    System.out.println("test:" + test(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    System.out.println("test:" + test(new String[]{"bat", "tab", "cat"}));
  }
}

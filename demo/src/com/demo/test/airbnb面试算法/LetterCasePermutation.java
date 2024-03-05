package com.demo.test.airbnb面试算法;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {
  
  public static List<String> letterCasePermutation(String S) {
    if (S == null) {
      return new LinkedList<>();
    }
    Queue<String> queue = new LinkedList<>();
    queue.offer(S);
    
    for (int i = 0; i < S.length(); i++) {
      if (Character.isDigit(S.charAt(i))) continue;
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        String cur = queue.poll();
        char[] chs = cur.toCharArray();
        
        chs[i] = Character.toUpperCase(chs[i]);
        queue.offer(String.valueOf(chs));
        
        chs[i] = Character.toLowerCase(chs[i]);
        queue.offer(String.valueOf(chs));
      }
    }
    
    return new LinkedList<>(queue);
  }
  
  /**
   * Find all the combinations of a string in lowercase and uppercase.
   * For example,
   * string "ab" >>> "ab", "Ab", "aB", "AB".
   * So, you will have 2^n (n = number of chars in the string) output strings.
   * The goal is for you to test each of these strings and see if it matchs a hidden string.
   */
  public static void main(String[] args) {
    List<String> list = letterCasePermutation("a1bC");
    for (String s : list) {
      System.out.println(s);
    }
  }
}

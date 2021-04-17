package com.demo.test.lll;

import java.util.regex.Pattern;

public class StringAdd {
  
  public static void main(String[] args) {
    try {
      String result = add("111923", "1699");
      System.out.println("========result========" + result);
    } catch (NumberFormatException e) {
      System.out.println("========result========" + e.getMessage());
    }
  }
  
  private static String add(String s1, String s2) {
    if (s1 == null) {
      return s2;
    }
    if (s2 == null) {
      return s1;
    }
    if (!isNum(s1) || !isNum(s2)) {
      return "-1";
    }
    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();
    int len1 = arr1.length - 1;
    int len2 = arr2.length - 1;
    StringBuilder result = new StringBuilder();
    int count = 0;
    while (len1 >= 0 && len2 >= 0) {
      int tmp = count(arr1[len1], arr2[len2]) + count;
      count = tmp > 10 ? 1 : 0;
      result.append(tmp % 10);
      len1--;
      len2--;
    }
    
    while (len1 >= 0) {
      int tmp = count(arr1[len1], '0') + count;
      count = tmp > 10 ? 1 : 0;
      result.append(tmp % 10);
      len1--;
    }
    
    while (len2 >= 0) {
      int tmp = count(arr2[len2], '0') + count;
      count = tmp > 10 ? 1 : 0;
      result.append(tmp % 10);
      len2--;
    }
    
    return result.reverse().toString();
  }
  
  private static int count(char a1, char a2) throws NumberFormatException {
    return Integer.parseInt(String.valueOf(a1)) + Integer.parseInt(String.valueOf(a2));
  }
  
  private static boolean isNum(String s) {
    Pattern pattern = Pattern.compile("[0-9]*");
    return pattern.matcher(s).matches();
  }
}

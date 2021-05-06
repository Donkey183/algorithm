package com.demo.test.lll;

import java.util.regex.Pattern;

public class 两数之和 {

  public static void main(String[] args) {
    try {
      String result = addString("111923", "1699");
      System.out.println("========result========" + result);
    } catch (NumberFormatException e) {
      System.out.println("========result========" + e.getMessage());
    }
  }

  public static String addString(String num1, String num2) {
    StringBuilder result = new StringBuilder(5200);
    int carry = 0;
    int l1 = num1.length();
    int l2 = num2.length();
    while (l1 > 0 || l2 > 0 || carry > 0) {
      int tem = carry;
      if (l1 > 0) {
        l1--;
        tem = tem + num1.charAt(l1) - '0';
      }
      if (l2 > 0) {
        l2--;
        tem = tem + num2.charAt(l2) - '0';
      }
      carry = tem / 10;
      result.append(tem % 10);
    }
    return result.reverse().toString();
  }
}

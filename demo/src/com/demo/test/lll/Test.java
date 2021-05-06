package com.demo.test.lll;

public class Test {

  public static void main(String[] args) {
    String str = "Hello";
    char[] arr = str.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      char c = arr[i];
      if (c >= 'a' && c <= 'z') {
        c -= 32;
        System.out.println(c);
//        System.out.println((Character.toUpperCase(c)));
      }
    }
  }
}

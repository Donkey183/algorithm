package com.demo.test.lll;


public class 反转URL {

  public static void main(String[] args) {
    String url = "www.baidu.com";
    String s = String.valueOf(reverse(url.toCharArray()));
    System.out.println("======result=======" + s);

  }

  private static char[] reverse(char[] values) {
    if (values == null || values.length == 0) {
      return null;
    }
    char[] rValues = reverse(values, 0, values.length - 1);
    int start = 0;
    for (int i = 0; i < rValues.length; i++) {
      if (rValues[i] == '.') {
        reverse(values, start, i - 1);
        start = i + 1;
      }
    }
    return values;
  }

  private static char[] reverse(char[] values, int start, int end) {
    for (int i = start; i < end; i++) {
      char c = values[i];
      values[i] = values[end];
      values[end] = c;
      end--;
    }
    return values;
  }
}

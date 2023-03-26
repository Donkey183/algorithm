package com.demo.test.其他;


public class 反转URL {

  public static void main(String[] args) {
    String url = "www.baidu.com";
    String s = String.valueOf(reverse(url.toCharArray()));
    System.out.println("======result=======" + s);
    System.out.println("======result2======" + reverse2(url));
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

  private static String reverse2(String str) {
    if(str == null || str.length() == 0) {
      return null;
    }
    String[] strs = str.split("\\.");
    int end = strs.length - 1;
    for(int i = 0; i < end; i++) {
      String tmp = strs[i];
      strs[i] = strs[end];
      strs[end] = tmp;
      end--;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < strs.length; i++) {
      sb.append(strs[i]).append(".");
    }
    return sb.deleteCharAt(sb.length()-1).toString();
  }

}

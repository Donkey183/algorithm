package com.demo.test.lll;


public class ReverseUrl {

  public static void main(String[] args) {
    String s = reverse("www.baidu.com");
    System.out.println("======result=======" + s);
  }


  private static String reverse(String url) {
    if (url == null || url.length() == 0) {
      return null;
    }
    int start = url.length() - 1;
    int index = url.length() - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = url.length() - 1; i > 0; i--) {
      if (url.charAt(i) == '.') {
        index = i;
        sb.append(url.substring(index + 1, start + 1));
        sb.append(".");
        start = index;
      }
    }
    sb.deleteCharAt(sb.length() - 1);
    sb.append(url.substring(0, start));
    return sb.toString();
  }
}

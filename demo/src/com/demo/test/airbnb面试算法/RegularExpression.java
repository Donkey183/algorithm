package com.demo.test.airbnb面试算法;

public class RegularExpression {
  public static boolean regMatch(String source, String pattern) {
    if (pattern.length() == 0) {
      return source.length() == 0;
    }
    if (pattern.length() == 1) {
      if (source.length() > 1 || source.length() == 0) {
        return false;
      }
      return source.charAt(0) == pattern.charAt(0);
    }
    
    if (source.length() != 0 && (pattern.charAt(0) == '.' || pattern.charAt(0) == source.charAt(0))) {
      if (pattern.charAt(1) == '*') {
        return regMatch(source.substring(1), pattern) || regMatch(source, pattern.substring(2));
      } else if (pattern.charAt(1) == '+') {
        return regMatch(source.substring(1), pattern.substring(2)) || regMatch(source.substring(1), pattern.substring(2));
      } else {
        return regMatch(source.substring(1), pattern.substring(1));
      }
    }
    return pattern.charAt(1) == '*' && regMatch(source, pattern.substring(2));
  }
  
  /**
   * Implement a simple regex parser which, given a string and a pattern, returns a boolean indicating whether the input matches the pattern.
   * <p>
   * By simple, we mean that the regex can only contain special character:
   * <p>
   * (star) The star means what you'd expect, that there will be zero or more of previous character in that place in the pattern.
   * . (dot) The dot means any character for that position.
   * + (plus). The plus means one or more of previous character in that place in the pattern.
   */
  
  public static void main(String[] args) {
    System.out.println(regMatch("aa", "a*"));
  }
}

package com.demo.test.lll;

import java.util.Stack;

public class 标准括号 {

  public static boolean isValid(String s) {
    if (s == null || s.length() < 2) {
      return false;
    }
    Stack<Character> stack = new Stack();
    char[] cs = s.toCharArray();
    for (int i = 0; i < cs.length; i++) {
      char c = cs[i];
      if (stack.isEmpty()) {
        stack.push(c);
      } else {
        if (c == ')' && stack.peek() == '(') {
          stack.pop();
        } else if (c == ']' && stack.peek() == '[') {
          stack.pop();
        } else if (c == '}' && stack.peek() == '{') {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }
    return stack.isEmpty();
  }


  public static void main(String[] args) {
    System.out.println(isValid("({{}}]"));
    System.out.println(isValid("({{}}]"));
    System.out.println(isValid("((())))"));
    System.out.println(isValid("({{}}]"));
    System.out.println(isValid("()"));
  }
}

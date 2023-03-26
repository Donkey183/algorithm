package com.demo.test.其他;

import java.util.Stack;

public class 设计一个有gitMin的栈 {

  /**
   * 最优解 时间、空间复杂度O(1) 但有使用限制条件，若数据范围无限制可能溢出
   * 题解url： https://www.cxyxiaowu.com/2968.html
   */
  public static class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private int min;

    public void push(int x) {
      if (stack.isEmpty()) {
        min = x;
        stack.push(0);
      } else {
        // 计算差值
        int compare = x - min;
        stack.push(compare);
        // 如果差值小于0，显然 x 成为最小值，否则最小值不变
        min = compare < 0 ? x : min;
      }
    }

    public Integer pop() {
      int top = stack.peek();
      // 如果top小于0，显然最小值也一并会被删除，此时更新最小值
      min = top < 0 ? (min - top) : min;
      int pop = stack.pop();
      return min + pop;
    }

    public int getMin() {
      return min;
    }
  }


  /**
   * 辅助栈解法 时间复杂度O(1), 空间复杂度O(n)
   */
  public static class Stack2 {

    // 定义两个栈
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> helper = new Stack<>();

    public static void push(Integer data) {
      // 目标栈正常入栈
      stack.push(data);

      if (helper.isEmpty()) {
        helper.push(data);
      }
      // 判断栈顶与要 push 元素的大小
      else if (helper.peek() <= data) {
        helper.push(data);
      } else {
        helper.push(helper.peek());
      }
    }

    public static Integer pop() {
      if (stack.isEmpty()) {
        return null;
      }
      helper.pop();
      return stack.pop();
    }

    public static Integer getMin() {
      return helper.isEmpty() ? null : helper.peek();
    }
  }

  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(2);
    stack.push(1);
    stack.push(3);
    stack.push(0);

    System.out.println("最小值: " + stack.getMin());
    System.out.println("pop: " + stack.pop());
    System.out.println("pop: " + stack.pop());
    System.out.println("最小值: " + stack.getMin());

    System.out.println("pop: " + stack.pop());
    System.out.println("最小值: " + stack.getMin());
  }
}
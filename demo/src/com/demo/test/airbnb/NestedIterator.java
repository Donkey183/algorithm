package com.demo.test.airbnb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
  private Deque<Integer> deque = new ArrayDeque<>();
  
  public NestedIterator(List<NestedInteger> nestedList) {
    flatten(nestedList, deque);
  }
  
  private void flatten(List<NestedInteger> nestedList, Deque<Integer> deque) {
    for (NestedInteger n : nestedList) {
      if (n.getInteger() == null) { // 表示是一个列表
        flatten(n.getList(), deque);
      } else {
        deque.offerLast(n.getInteger());
      }
    }
  }
  
  @Override
  public Integer next() {
    return deque.pollFirst();
  }
  
  @Override
  public boolean hasNext() {
    return !deque.isEmpty();
  }
  
  public interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
  }
  
  /**
   * Given a nested list of integers, implement an iterator to flatten it.
   * <p>
   * Each element is either an integer, or a list -- whose elements may also be integers or airbnb lists.
   */
  public static void main(String[] args) {
  
  }
}

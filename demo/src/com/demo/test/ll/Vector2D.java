package com.demo.test.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Vector2D {

  Iterator<List<Integer>> it;
  Iterator<Integer> curr;

  public Vector2D(List<List<Integer>> vec2d) {
    it = vec2d.iterator();
  }

  public int next() {
    if (hasNext()) {
      return curr.next();
    }
    return Integer.MIN_VALUE;
  }

  public boolean hasNext() {
    // 当前列表的迭代器为空，或者当前迭代器中没有下一个值时，需要更新为下一个迭代器
    while ((curr == null || !curr.hasNext()) && it.hasNext()) {
      curr = it.next().iterator();
    }
    return curr != null && curr.hasNext();
  }

  public void remove() {
    while (curr == null && it.hasNext()) {
      curr = it.next().iterator();
    }

    if (curr != null) {
      curr.remove();
    }
  }

  /**
   * https://segmentfault.com/a/1190000003791233 Implement an iterator to flatten a 2d vector. For
   * example, Given 2d vector = [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext
   * returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
   */
  public static void main(String[] args) {
    List<Integer> l1 = new ArrayList(Arrays.asList(new Integer[]{1, 2}));
    List<Integer> l2 = new ArrayList(Arrays.asList(new Integer[]{3}));
    List<Integer> l3 = new ArrayList(Arrays.asList(new Integer[]{4, 5, 6}));
    List<List<Integer>> value = new ArrayList<>();
    value.add(l1);
    value.add(l2);
    value.add(l3);
    Vector2D vector2D = new Vector2D(value);
    System.out.println(vector2D.hasNext());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());
    System.out.println(vector2D.next());

  }
}

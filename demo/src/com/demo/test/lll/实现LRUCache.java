package com.demo.test.lll;

import java.util.*;

public class 实现LRUCache {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(3);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    System.out.println(cache.get(1));
    System.out.println(cache.get(5));
    System.out.println(cache.get(4));
    cache.put(6, 6);
    cache.put(7, 7);
    cache.put(8, 8);
    System.out.println(cache.get(5));
  }

  /**
   * 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
   * set(key, value)：将记录(key, value)插入该结构
   * get(key)：返回key对应的value值 [要求] set和get方法的时间复杂度为O(1) 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
   * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。 若opt=1，接下来两个整数x, y，表示set(x, y)
   * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1 对于每个操作2，输出一个答案
   */
  public int[] LRU(int[][] operators, int k) {
    if (operators == null || k <= 0) {
      return null;
    }
    LRUCache cache = new LRUCache(k);
    List<Integer> result = new ArrayList();
    for (int i = 0; i < operators.length; i++) {
      int[] row = operators[i];
      if (row[0] == 1) {
        cache.put(row[1], row[2]);
      } else if (row[0] == 2) {
        result.add(cache.get(row[1]));
      }
    }

    int[] resultArr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resultArr[i] = result.get(i);
    }

    return resultArr;
  }


  public static class LRUCache {

    private Map<Integer, Integer> map;
    private int size;

    public LRUCache(int size) {
      this.size = size;
      map = new LinkedHashMap<>(size);
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        map.remove(key);
      }
      if (map.size() >= size) {
        map.remove(map.keySet().iterator().next());
      }
      map.put(key, value);
    }

    public int get(int key) {
      int value = -1;
      if (map.containsKey(key)) {
        value = map.get(key);
        map.remove(key);
        map.put(key, value);
      }
      return value;
    }
  }
}

package com.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoSumIV {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public boolean findTarget(TreeNode root, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    random.nextInt(1);
    put(root, map);
    for(Integer key : map.keySet()){
      if(key * 2 == k && map.get(key) >=2) {
        return true;
      }
      if(key * 2 != k && map.containsKey(k - key)) {
        return true;
      }
    }
    return false;
  }

  public Map<Integer, Integer> put(TreeNode root, Map<Integer, Integer> map) {
    if(root == null) {
      return map;
    }
    if(map.containsKey(root.val)) {
      map.put(root.val, map.get(root.val) + 1);
    }
    map.put(root.val, 1);
    map = put(root.left, map);
    map = put(root.right, map);
    return map;
  }

}

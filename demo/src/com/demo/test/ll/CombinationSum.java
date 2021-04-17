package com.demo.test.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static List<List<Double>> combinationSum(double[] candidates, double target) {
    List<List<Double>> res = new ArrayList<>();
    Arrays.sort(candidates);
    helper(candidates, 0, target, new ArrayList<Double>(), res);
    return res;
  }

  private static void helper(double[] can, int start, double target, List<Double> each,
      List<List<Double>> res) {
    for (int i = start; i < can.length; i++) {
      List<Double> temp = new ArrayList<>(each);
      if (can[i] == target) {
        // 递归终止条件: can[i] >= target
        temp.add(can[i]);
        res.add(temp);
        break;
      } else if (can[i] < target) {
        temp.add(can[i]);
        // start = i +1 则不重复使用元素
        helper(can, i + 1, target - can[i], new ArrayList<>(temp), res);
      } else {
        // 递归终止条件: can[i] >= target, 因为can[i]是有序的, target也是每一次递归都会变小 target = target - can[i]
        break;
      }
    }
    return;
  }

  /**
   * Given a set of candidate numbers (candidates) (without duplicates) and a target number
   * (target), find all unique combinations in candidates where the candidate numbers sums to
   * target. The same repeated number may be chosen from candidates unlimited number of times. Note:
   * All numbers (including target) will be positive integers. The solution set must not contain
   * duplicate combinations. Example 1: Input: candidates = [2,3,6,7], target = 7, A solution set
   * is: [ [7], [2,2,3] ]
   */

  public static void main(String[] args) {
    List<List<Double>> result = combinationSum(new double[]{1.0d, 2d, 3d, 6.0d, 7d}, 7.0d);
    for (List<Double> list : result) {
      for (Double d : list) {
        System.out.print(d + ",");
      }
      System.out.println();
    }
  }

  private List<List<Double>> combinationSum2(double[] cans, double target) {
    return null;
  }

  private void helper(double[] cans, double target, List<List<Double>> result, List<Double> tmpList) {

  }

}

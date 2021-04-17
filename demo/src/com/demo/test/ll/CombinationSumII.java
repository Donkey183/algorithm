package com.demo.test.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();
    Arrays.sort(candidates); // need sort to make this work.
    combination(candidates, target, 0, comb, ans);
    return ans;
  }
  
  private static void combination(int[] candi, int target, int start, List<Integer> comb, List<List<Integer>> ans) {
    for (int i = start; i < candi.length; i++) {
      if (i > start && candi[i] == candi[i - 1]) {//remove duplicates.
        continue;
      }
      if (candi[i] == target) {
        //recursion exit.
        List<Integer> newComb = new ArrayList<>(comb);
        newComb.add(candi[i]);
        ans.add(newComb);
      } else if (candi[i] < target) {
        //continue to look for the rest.
        List<Integer> newComb = new ArrayList<>(comb);
        newComb.add(candi[i]);
        combination(candi, target - candi[i], i + 1, newComb, ans);
      } else {
        break; //invalid path, return nothing.
      }
    }
  }
  
  /**
   * Given a collection of candidate numbers (candidates) and a target number (target),
   * find all unique combinations in candidates where the candidate numbers sums to target.
   * Each number in candidates may only be used once in the combination.
   * Note:
   * All numbers (including target) will be positive integers.
   * The solution set must not contain duplicate combinations.
   * Example 1:
   * Input: candidates = [10,1,2,7,6,1,5], target = 8,
   * A solution set is:
   * [
   * [1, 7],
   * [1, 2, 5],
   * [2, 6],
   * [1, 1, 6]
   * ]
   */
  
  public static void main(String[] args) {
    List<List<Integer>> result = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    for (List<Integer> list : result) {
      for (Integer integer : list) {
        System.out.print(integer + ",");
      }
      System.out.println();
    }
  }
}

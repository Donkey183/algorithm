package com.demo.test.lll;

public class UniquePaths {
  public static int uniquePaths(int m, int n) {
    int[][] a = new int[n][m];
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0) {
          a[i][j] = 1;
        } else if (j == 0) {
          a[i][j] = 1;
        } else {
          a[i][j] = a[i - 1][j] + a[i][j - 1];
        }
      }
    }
    return a[n - 1][m - 1];
  }
  
  /**
   * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
   * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
   * How many possible unique paths are there?
   * <p>
   * <p>
   * Input: m = 3, n = 2
   * Output: 3
   * Explanation:
   * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
   * 1. Right -> Right -> Down
   * 2. Right -> Down -> Right
   * 3. Down -> Right -> Right
   * <p>
   * <p>
   * <p>
   * Input: m = 7, n = 3
   * Output: 28
   * <p>
   * https://leetcode.com/problems/unique-paths/
   */
  
  public static void main(String[] args) {
    System.out.println("=======total way:=====" + uniquePaths(1, 1));
  }
}

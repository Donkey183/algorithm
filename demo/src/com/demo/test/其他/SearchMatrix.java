package com.demo.test.其他;

import java.util.HashMap;
import java.util.Map;

public class SearchMatrix {
  
  private static boolean isContains(int[][] a, int target) {
    int i = 0;
    int j = a[0].length - 1;
    while (i < a.length && j >= 0) {
      if (a[i][j] > target) {
        j--;
      } else if (a[i][j] < target) {
        i++;
      } else {
        return true;
      }
    }
    
    return false;
  }
  
  public static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if (m == 0) return false;
    int n = matrix[0].length;
    int min = 0, max = m * n - 1;
    while (min <= max) {
      int mid = min + (max - min) / 2;
      int row = mid / n;
      int col = mid % n;
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    int[][] a = new int[][]{
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}};
    int[][] b = new int[][]{
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}};
    System.out.println("====isContains====" + searchMatrix(a, 50));
  }
  
}

package com.demo.test.其他;

public class 快排 {
  public static void quickSort(int[] arr) {
    qsort(arr, 0, arr.length - 1);
  }
  
  private static void qsort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);        //将数组分为两部分
      qsort(arr, low, pivot - 1);              //递归排序左子数组
      qsort(arr, pivot + 1, high);             //递归排序右子数组
    }
  }
  
  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];     //枢轴记录
    while (low < high) {
      while (low < high && arr[high] >= pivot) {
        high--;
      }
      arr[low] = arr[high];             //交换比枢轴小的记录到左端
      while (low < high && arr[low] <= pivot) {
        low++;
      }
      arr[high] = arr[low];           //交换比枢轴小的记录到右端
    }
    //扫描完成，枢轴到位
    arr[low] = pivot;
    //返回的是枢轴的位置
    return low;
  }
  
  public static void main(String[] args) {
    int a[] = new int[]{1, 5, 2, 8, 6, -3, 9, 18};
    quickSort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }
}

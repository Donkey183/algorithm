package com.demo.test.其他;

import java.util.Arrays;

public class 小于n的最大数 {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 6};
        int tArr[] = {1, 3, 6};
        int[] res = max(arr, tArr);
        for (Integer i : res) {
            System.out.print(i);
        }
    }

    public static int[] max(int[] arr, int[] tArr) {
        Arrays.sort(tArr);
        int[] res = new int[arr.length];
        boolean smallerOrEqual = true;
        int one = findOne(tArr, arr[0], smallerOrEqual, false);
        res[0] = one;
        boolean useMax = one == -1 || one < arr[0];
        boolean allTheSame = true;
        for (int i = 1; i < arr.length; i++) {
            if (useMax) {
                res[i] = findOne(tArr, arr[i], smallerOrEqual, true);
                allTheSame = false;
                System.out.println("===change==allTheSame===");
                continue;
            }

            int tmp = findOne(tArr, arr[i], smallerOrEqual, useMax);
            res[i] = tmp;
            if (tmp < arr[i] && !useMax) {
                useMax = true;
            }
            if (allTheSame && arr[i] != tmp) {
                System.out.println("===change==allTheSame===");
                allTheSame = false;
            }
        }
        System.out.println("===allTheSame===" + allTheSame);
        if (allTheSame) {
            res[res.length - 1] = findSmaller(tArr, arr[arr.length - 1]);
        }
        return res;
    }


    /**
     * 从大到小查找到数
     */
    public static int findOne(int[] arr, int n, boolean smallerOrEqual, boolean max) {
        System.out.println("===findOne===start===n: " + n + " ,smallerOrEqual = " + smallerOrEqual + " , max= " + max);
        if (max) {
            System.out.println("===findOne===res===" + arr[arr.length - 1]);
            return arr[arr.length - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= n && smallerOrEqual) {
                System.out.println("===findOne===res===" + arr[i]);
                return arr[i];
            }
        }
        System.out.println("===findOne===res===" + -1);
        return -1;
    }

    /**
     * 从大到小查找到一个比n小的数
     */
    public static int findSmaller(int[] arr, int n) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < n) {
                return arr[i];
            }
        }
        return -1;
    }

}

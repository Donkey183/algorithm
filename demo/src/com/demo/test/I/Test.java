package com.demo.test.I;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("Result=");
        int arr[] = {1, 3, 2, 5, 4};
        Arrays.sort(arr);
        int result[] = Arrays.copyOf(arr, 3);
        for(Integer i : result) {
            System.out.println(i);
        }
    }
}

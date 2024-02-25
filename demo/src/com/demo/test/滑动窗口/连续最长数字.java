package com.demo.test.滑动窗口;

public class 连续最长数字 {

    public static int findMaxNum(String input) {
        int start = 0;
        int end = 0;
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                start = i;
                end = i;
                while (end < input.length()) {
                    if (input.charAt(end) >= '0' && input.charAt(end) <= '9') {
                        end++;
                    } else {
                        break;
                    }
                }
                if (end - start > max) {
                    max = end - start;
                    i = end;
                }
            }
        }
        return max;
    }
}

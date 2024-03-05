package com.demo.test.其他;

public class 最长公共前缀 {
    /**
     * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
     * 输入：
     * ["abca","abc","abca","abc","abcc"]
     * 返回值：
     * "abc"
     * https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=295&tqId=732&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     */

    public static String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String tmp = strs[0];
        int len = tmp.length();
        String res = "";

        for (int i = 0; i < len; i++) {
            for (String str : strs) {
                if (str.length() < i + 1 || !str.startsWith(tmp.substring(0, i + 1))) {
                    return res;
                }
            }
            res = tmp.substring(0, i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "abcd", "abcdde", "abctt"};
        String res = longestCommonPrefix(strs);
        System.out.println("===res===" + res);
    }
}

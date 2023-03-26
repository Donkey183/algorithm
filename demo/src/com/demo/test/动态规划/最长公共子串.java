package com.demo.test.动态规划;

public class 最长公共子串 {
    /**
     * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
     * 题目保证str1和str2的最长公共子串存在且唯一。
     * 输入: "1AB2345CD","12345EF"
     * 输出: 2345
     * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=295&tqId=991150&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     */
    public String LCS(String str1, String str2) {
        int maxLenth = 0;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[] dp = new int[str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            //注意这里是倒叙
            for (int j = str2.length() - 1; j >= 0; j--) {
                //递推公式，两个字符相等的情况
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[j + 1] = dp[j] + 1;
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[j + 1] > maxLenth) {
                        maxLenth = dp[j + 1];
                        maxLastIndex = i;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[j + 1] = 0;
                }
            }
        }
        //最字符串进行截取，substring(a,b)中a和b分别表示截取的开始和结束位置
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex + 1);
    }
}

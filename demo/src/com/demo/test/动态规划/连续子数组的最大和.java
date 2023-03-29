package com.demo.test.动态规划;

public class 连续子数组的最大和 {
    /**
     * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
     * 输入：[1,-2,3,10,-4,7,2,-5]
     * 输出：18，因为 3,10,-4,7,2 和最大为18
     * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=295&tqId=23259&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * <p>
     * <p>
     * 动态规划，设动态规划列表 dp，dp[i] 代表以元素 array[i] 为结尾的连续子数组最大和。
     * 状态转移方程： dp[i] = Math.max(dp[i-1]+array[i], array[i]);
     * 具体思路如下：
     * 1.遍历数组，比较 dp[i-1] + array[i] 和 array[i]的大小;
     * 2.为了保证子数组的和最大，每次比较 sum 都取两者的最大值;
     * 3.用max变量记录计算过程中产生的最大的连续和dp[i]；
     */
    public int findGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            // 动态规划，状态转移方程，确定dp[i]的最大值
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 优化动态规划，时间复杂度O(n)，空间复杂度O(1)
     * <p>
     * 我们可以简化动态规划，使用一个变量sum来表示当前连续的子数组和，以及一个变量max来表示中间出现的最大的和
     *
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray2(int[] array) {
        int sum = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            // 优化动态规划，确定sum的最大值
            sum = Math.max(sum + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max, sum);
        }
        return max;
    }
}

package com.demo.test.动态规划;

public class 买股票最佳时机2 {

    /**
     * 可多次买卖
     * 假设你有一个数组prices，长度为n，其中prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
     * 1. 你可以多次买卖该只股票，但是再次购买前必须卖出之前的股票
     * 2. 如果不能获取收益，请返回0
     * 3. 假设买入卖出均无手续费
     * <p>
     * 输入：[8,9,2,5,4,7,1]
     * 输出：7
     * <p>
     * 说明：
     * 在第1天(股票价格=8)买入，第2天(股票价格=9)卖出，获利9-8=1
     * 在第3天(股票价格=2)买入，第4天(股票价格=5)卖出，获利5-2=3
     * 在第5天(股票价格=4)买入，第6天(股票价格=7)卖出，获利7-4=3
     * 总获利1+3+3=7，返回7
     * <p>
     * https://www.nowcoder.com/practice/9e5e3c2603064829b0a0bbfca10594e9?tpId=295&tqId=1073471&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * <p>
     * 1、使用变量记录历史最低价格 minprice
     * 2、则在第 i 天卖出股票能得到的利润就是 prices[i] - minprice
     * 3、因此，我们只需要遍历价格数组一遍，记录历史最低点
     * <p>
     * 思路：
     * 其实我们要想获取最大收益，只需要在低价买入高价卖出就可以了，因为可以买卖多次。利用贪心思想：只要一段区间内价格是递增的，那么这段区间的差值就是我们可以有的收益。
     * <p>
     * 具体做法：
     * step 1：遍历数组，只要数组后一个比前一个更大，就可以有收益。
     * step 2：将收益累加，得到最终结果。
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            //只要某段在递增就有收益
            if (prices[i - 1] < prices[i]) {
                //收益累加
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}

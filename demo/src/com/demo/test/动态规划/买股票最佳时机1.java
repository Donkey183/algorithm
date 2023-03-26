package com.demo.test.动态规划;

public class 买股票最佳时机1 {

    /**
     * 只能买卖一次
     * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
     * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
     * 2.如果不能获取到任何利润，请返回0
     * 3.假设买入卖出均无手续费
     * <p>
     * 输入：[8,9,2,5,4,7,1]
     * 输出：5
     * 说明：在第3天(股票价格 = 2)的时候买入，在第6天(股票价格 = 7)的时候卖出，最大利润 = 7-2 = 5 ，不能选择在第2天买入，第3天卖出，这样就亏损7了；同时，你也不能在买入前卖出股票
     * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=295&tqId=625&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     *
     * 1、使用变量记录历史最低价格 minprice
     * 2、则在第 i 天卖出股票能得到的利润就是 prices[i] - minprice
     * 3、因此，我们只需要遍历价格数组一遍，记录历史最低点
     */
    public int maxProfit(int[] prices) {
        //维护最大收益
        int res = 0;
        //排除特殊情况
        if (prices.length == 0) {
            return res;
        }
        //维护最低股票价格
        int Min = prices[0];
        //遍历后续股票价格
        for (int i = 1; i < prices.length; i++) {
            //如果当日价格更低则更新最低价格
            Min = Math.min(Min, prices[i]);
            //维护最大值
            res = Math.max(res, prices[i] - Min);
        }
        return res;
    }
}

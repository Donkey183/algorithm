package com.demo.test.其他;

public class 连续最大1 {
    /**
     * 连续最大1
     */
    public int findMaxConsecutiveOne(int nums[]) {
        int left = 0, right = 0;
        int res = 0;
        int len = nums.length;
        while (right < len) {
            if (nums[right] == 1)
                right++;
            else {
                right++;
                left = right;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * 翻转k个0，求连续最大1
     * 翻转1个0，求连续最大1, 将K设置为1
     */
    public static int longestOnes(int[] nums, int k) {
        int count = 0;//统计0的个数
        int left = 0;//滑动窗口区间左端点
        int right = 0;//滑动窗口区间右端点
        int res = 0;//最终结果
        //滑动窗口表示的区间为[left,right)，左闭右开
        while (right < nums.length) {
            if (nums[right++] == 0) {//窗口扩充一个元素，如果为0则count++；
                count++;
            }
            while (count > k) {//当窗口内0的个数超过k时候，开始收缩窗口
                if (nums[left++] == 0) {//如果刚滑出窗口的元素是0，则count--;
                    count--;
                }
            }
            //此时count<=K,保存窗口的最大宽度
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 0, 0, 0, 1};
        System.out.println(longestOnes(nums, 2));
    }
}

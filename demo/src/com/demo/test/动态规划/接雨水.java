package com.demo.test.动态规划;

public class 接雨水 {
    /**
     * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个柱子高度图，计算按此排列的柱子，下雨之后能接多少雨水。(数组以外的区域高度视为0)
     * 输入：
     * [3,1,2,5,2,4]
     * 返回值：
     * 5
     * 说明：
     * 数组 [3,1,2,5,2,4] 表示柱子高度图，在这种情况下，可以接 5个单位的雨水，蓝色的为雨水 ，如题面图。
     * https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=295&tqId=1002045&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * <p>
     * <p>
     * 思路：
     * <p>
     * 我们都知道水桶的短板问题，控制水桶水量的是最短的一条板子。这道题也是类似，我们可以将整个图看成一个水桶，两边就是水桶的板，中间比较低的部分就是水桶的底，由较短的边控制水桶的最高水量。但是水桶中可能出现更高的边，比如上图第四列，它比水桶边还要高，那这种情况下它是不是将一个水桶分割成了两个水桶，而中间的那条边就是两个水桶的边。
     * <p>
     * 有了这个思想，解决这道题就容易了，因为我们这里的水桶有两个边，因此可以考虑使用对撞双指针往中间靠。
     * <p>
     * 具体做法：
     * <p>
     * step 1：检查数组是否为空的特殊情况
     * step 2：准备双指针，分别指向数组首尾元素，代表最初的两个边界
     * step 3：指针往中间遍历，遇到更低柱子就是底，用较短的边界减去底就是这一列的接水量，遇到更高的柱子就是新的边界，更新边界大小。
     */

    public long maxWater(int[] arr) {
        //排除空数组
        if (arr.length == 0) {
            return 0;
        }
        long res = 0;
        //左右双指针
        int left = 0;
        int right = arr.length - 1;
        //中间区域的边界高度
        int maxL = 0;
        int maxR = 0;
        //直到左右指针相遇
        while (left < right) {
            //每次维护往中间的最大边界
            maxL = Math.max(maxL, arr[left]);
            maxR = Math.max(maxR, arr[right]);
            //较短的边界确定该格子的水量
            if (maxR > maxL) {
                res += maxL - arr[left++];
            } else {
                res += maxR - arr[right--];
            }
        }
        return res;
    }


}

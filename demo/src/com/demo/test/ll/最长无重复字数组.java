package com.demo.test.ll;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 最长无重复字数组 {

    /**
     * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     * <p>
     * 输入：
     * [2,3,4,5]
     * 返回值：
     * 4
     * 说明：
     * [2,3,4,5]是最长子数组
     * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=295&tqId=1008889&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * <p>
     * 我们可以用一个队列，把元素不停的加入到队列中，如果有相同的元素，就把队首的元素移除，这样我们就可以保证队列中永远都没有重复的元素
     */
    public static int maxLength(int[] arr) {
        //用链表实现队列，队列是先进先出的
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for (int c : arr) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }

    /**
     * 解法2
     * 双指针
     */
    public static int maxLength2(int[] arr) {
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
            System.out.println("===j===" + j + "===max===" + max);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2, 3, 4};
        int res = maxLength2(arr);
        System.out.println("===res===" + res);
    }
}

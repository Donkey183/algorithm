package com.demo.test.滑动窗口;

import java.util.*;

public class 滑动窗口的最大值 {
    /**
     * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
     * <p>
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * <p>
     * 窗口大于数组长度或窗口长度为0的时候，返回空。
     * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=295&tqId=23458&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * <p>
     * 暴力破解法
     * 时间复杂度：O(nm)，其中，n为数组长度，m为窗口长度，双层for循环
     * 空间复杂度: O(1)
     */
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = 0;
        if (num.length == 0 || size > num.length || size == 0) {
            return list;
        }
        for (int i = 0; i <= num.length - size; i++) {
            // 寻找每个窗口最大值
            max = num[i];
            for (int j = i; j < size + i; j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }

    /**
     * 使用大顶堆
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        //大顶堆，从大到小的排列
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //存放结果集
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (num == null || num.length == 0 || num.length < size || size <= 0) {
            return result;
        }
        for (int i = 0; i < size; i++) {
            heap.offer(num[i]);
        }
        result.add(heap.peek());
        //i从1到num.length-size
        for (int i = 1; i < num.length + 1 - size; i++) {
            heap.remove(num[i - 1]);
            heap.offer(num[i + size - 1]);
            result.add(heap.peek());
        }
        return result;
    }


    /**
     * 使用双端队列
     *
     * 使用一个单调递减栈保存数组下标，用单调递减栈的原因是为了使栈的最左是当前窗口的最大值，如果用递增栈无法保证栈的右边是当前栈的最大值。
     * 循环遍历如果数据过期就弹出保证当前栈的最左边是该窗口最大值的坐标。
     */
    public ArrayList<Integer> maxInWindows3(int[] num, int size) {

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        if (size == 0 || num.length == 0 || size > num.length) return list;
        for (int i = 0; i < size; i++) {

            while (!stack.isEmpty() && num[stack.peekLast()] < num[i]) {
                stack.pollLast();
            }
            stack.add(i);
        }
        list.add(num[stack.peekFirst()]);
        for (int i = 1; i < num.length - size + 1; i++) {
            while (!stack.isEmpty() && i > stack.peekFirst()) {
                stack.pollFirst();
            }
            while (!stack.isEmpty() && num[stack.peekLast()] < num[i + size - 1]) {
                stack.pollLast();
            }
            stack.addLast(i + size - 1);

            list.add(num[stack.peekFirst()]);

        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        List<Integer> res = maxInWindows(arr, 3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}

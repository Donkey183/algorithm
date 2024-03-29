package com.demo.test.动态规划;

import java.util.LinkedList;
import java.util.List;

class 复原IP地址 {
    List<String> res = new LinkedList<>();
    LinkedList<String> segment = new LinkedList<>();

    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * <p>
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     * https://leetcode.cn/problems/restore-ip-addresses/solution/shou-hua-tu-jie-huan-yuan-dfs-hui-su-de-xi-jie-by-/
     *
     * 思路:
     * 回溯 + 剪枝
     */
    public List<String> restoreIpAddresses(String s) {
        helper(s, 0);
        return res;
    }

    void helper(String s, int start) {
        if (start == s.length() && segment.size() == 4) {
            StringBuilder t = new StringBuilder();
            for (String se : segment) t.append(se).append(".");
            t.deleteCharAt(t.length() - 1);
            res.add(t.toString());
            return;
        }
        if (start < s.length() && segment.size() == 4) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i - 1 >= s.length()) {
                return;
            }
            if (i != 1 && s.charAt(start) == '0') {
                return;
            }
            String str = s.substring(start, start + i);
            if (i == 3 && Integer.parseInt(str) > 255) {
                return;
            }
            segment.addLast(str);
            helper(s, start + i);
            segment.removeLast();
        }
    }


    public static void main(String[] args) {

    }
}
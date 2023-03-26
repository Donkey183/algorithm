package com.demo.test.二叉树;

import java.util.*;

public class 二叉树是否存在两数之和 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Set<Integer> set = new HashSet<>();

    /**
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-shu-ru-bst-by-leetco-b4nl/
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /**
     * 解法2
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/solution/liang-shu-zhi-he-iv-shu-ru-bst-by-leetco-b4nl/
     */
    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }
}

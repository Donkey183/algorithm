package com.demo.test.二叉树;

public class 二叉树最近公共祖先 {
    public 二叉树.TreeNode lowestCommonAncestor(二叉树.TreeNode root, 二叉树.TreeNode p, 二叉树.TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        二叉树.TreeNode left = lowestCommonAncestor(root.left, p, q);
        二叉树.TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left 和 right都不为空，说明此时root就是最近公共节点
        // 如果left为空，right不为空，就返回right，说明目标节点是通过right返回的，反之亦然。
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}

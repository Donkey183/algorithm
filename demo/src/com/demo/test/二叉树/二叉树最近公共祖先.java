package com.demo.test.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树最近公共祖先 {

    /**
     * 递归写法
     * 时间复杂度：O（n），n是二叉树节点的个数，最坏情况下每个节点都会被访问一遍
     * 空间复杂度：O（n），因为是递归，取决于栈的深度，最差最差情况下，二叉树退化成链表，栈的深度是n。
     * <p>
     * 解题思路：根据公共祖先的定义，若root是o1、o2的最近公共祖先，则只可能为以下三种情况之一
     * ① p 和 q 分别在 root 的左右子树中
     * ② p = root 且 q 在 root 的 左或右子树中
     * ③ q = root 且 p 在 root 的 左或右子树中
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果root为空，或者root为o1、o2中的一个，则它们的最近公共祖先就为root
        if (root == p || root == q || root == null) {
            return root;
        }

        // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        // 我们只需要返回root结点即可。
        if (left != null && right != null) {
            return root;
        }

        // 如果在左子树中p和q都找不到，则p和q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        if (left == null) {
            return right;
        }
        return left;
    }


    /**
     * 非递归写法
     * <p>
     * 解题思路:
     * 首先找到根节点到两个节点的路径
     * 然后将其中一个路径加入到哈希表或者链表中
     * 然后遍历另一个路径，在哈希表\链表中有相同的则返回即可
     */
    public int lowestCommonAncestor2(TreeNode root, int o1, int o2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        path1.add(root.val);
        getPath(root, o1, path1);
        path2.add(root.val);
        getPath(root, o2, path2);
        int res = 0;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                res = path1.get(i);
            } else {
                // 第一次出现值不一样, 说明res就是公共祖先
                break;
            }
        }
        return res;
    }

    private boolean getPath(TreeNode root, int node, List<Integer> path) {
        if (root.val == node) {
            return true;
        }

        if (root.left != null) {
            path.add(root.left.val);
            if (getPath(root.left, node, path)) {
                return true;
            } else {
                path.remove(path.size() - 1);
            }
        }
        
        if (root.right != null) {
            path.add(root.right.val);
            if (getPath(root.right, node, path)) {
                return true;
            } else {
                path.remove(path.size() - 1);
            }
        }
        return false;
    }


    /**
     * 给定的是任意两个节点的值
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return helper(root, o1, o2).val;
    }

    public TreeNode helper(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2)
            return root;
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);
        //如果left为空，说明这两个节点在root结点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null) {
            return right;
        }

        //同上
        if (right == null) {
            return left;
        }
        //如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        //我们只需要返回cur结点即可。
        return root;
    }
}

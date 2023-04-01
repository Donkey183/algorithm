package com.demo.test.二叉树;

import java.util.*;

public class 二叉树 {
    /**
     * 前序遍历递归
     */
    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            System.out.println("preOrder:" + root.val);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

    /**
     * 中序递归遍历
     */
    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            System.out.println("inorder:" + root.val);
            inorder(root.right, list);
        }
    }

    /**
     * 后序递归遍历
     */
    public void postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
            System.out.println("postorder:" + root.val);
        }
    }


    public static TreeNode initTree() {
        TreeNode root = new TreeNode(100);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;
        return root;
    }

    /**
     * 前序遍历非递归
     */
    public static void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val + "  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    /**
     * 中序遍历非递归
     */
    public void inOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                System.out.print(node.val + "  ");
                pNode = node.right;
            }
        }
    }

    /**
     * 二叉树深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 二叉树的最大深度 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/path-sum
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = initTree();
//        preOrder(root, new ArrayList<Integer>());
//        System.out.println("maxDepth=" + maxDepth2(root));
//        System.out.println("hasPathSum=" + hasPathSum(root, 101));
    }
}

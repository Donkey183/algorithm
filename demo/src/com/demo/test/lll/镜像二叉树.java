package com.demo.test.lll;

import java.util.Stack;

public class 镜像二叉树 {
    /**
     * 主要是利用栈（或队列）遍历树的所有节点 node ，并交换每个 node 的左 / 右子节点
     * 算法流程：
     * 1、特例处理： 当 pRoot为空时，直接返回 null ；
     * 2、初始化： 栈（或队列），本文用栈stack ，并加入根节点 pRoot。
     * 3、循环交换： 当栈 stack 为空时跳出；
     * 3.1、出栈： 记为 node ；
     * 3.2、添加子节点： 将 node 左和右子节点入栈；
     * 3.3、交换： 交换 node 的左 / 右子节点。
     * 4、返回值： 返回根节点 pRoot 。
     */
    public 二叉树.TreeNode Mirror(二叉树.TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return null;
        }
        // 构建辅助栈
        Stack<二叉树.TreeNode> stack = new Stack<>();
        // 根节点入栈
        stack.add(pRoot);
        while (!stack.isEmpty()) {
            // 节点出栈
            二叉树.TreeNode node = stack.pop();
            // 根节点的左右子树入栈
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            // 左右子树交换
            二叉树.TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return pRoot;
    }
}
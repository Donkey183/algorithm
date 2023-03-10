package com.demo.test.lll;

import java.util.*;

public class 水平和z形打印二叉树 {

    /**
     * 水平打印二叉树
     */
    public static List<List<Integer>> levelOrder(二叉树.TreeNode root) {
        List<List<Integer>> res = new ArrayList();//用于返回最后的结果
        if (root == null) {
            return res;//如果根节点为空就返回结果
        }
        Queue<二叉树.TreeNode> queue = new LinkedList<二叉树.TreeNode>();//用于存储每一层的节点
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();//用于存储当前遍历这一层的节点
            for (int i = 0; i < n; i++) {
                二叉树.TreeNode node = queue.poll();//取出队列的第一个元素
                temp.add(node.val);//将队头元素保存起来
                if (node.left != null) {
                    queue.add(node.left);//左孩子如果不为空就进队列
                }
                if (node.right != null) {
                    queue.add(node.right);//右孩子如果不为空就进队列
                }
            }
            res.add(temp);//将这一层的节点数里面据保存到res
        }
        return res;
    }

    /**
     * z形打印二叉树
     */
    public static List<List<Integer>> zLevelOrder(二叉树.TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<二叉树.TreeNode> nodeQueue = new LinkedList<二叉树.TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                二叉树.TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }

    public static void main(String[] args) {
        二叉树.TreeNode root = 二叉树.initTree();

        List<List<Integer>> result = levelOrder(root);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + ", ");
            }
        }
    }
}

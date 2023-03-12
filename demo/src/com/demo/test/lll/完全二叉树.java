package com.demo.test.lll;

import java.util.*;

public class 完全二叉树 {
    public boolean isCompleteTree(二叉树.TreeNode root) {
        //空树一定是完全二叉树
        if (root == null) {
            return true;
        }
        //辅助队列
        Queue<二叉树.TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        二叉树.TreeNode cur;
        //定义一个首次出现的标记位
        boolean notComplete = false;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            //标记第一次遇到空节点
            if (cur == null) {
                notComplete = true;
                continue;
            }
            //后续访问已经遇到空节点了，说明经过了叶子
            if (notComplete) {
                return false;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}

package com.demo.test.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度 {
    /**
     * 递归实现
     * <p>
     * 求给定二叉树的最大深度，
     * 深度是指树的根节点到任一叶子节点路径上节点的数量。
     * 最大深度是所有叶子节点的深度的最大值。
     * https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=295&tqId=642&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * <p>
     * 定义递归函数功能：获取root结点的最大深度
     * 递归终止条件：root为null
     * 返回值：先递归左子结点，再递归右子结点，最后求出每一子树的深度的最大值
     * <p>
     * 时间复杂度 O(N)：计算所有结点的深度的递归需要经过每个结点
     * 空间复杂度 O(N)：递归占用的栈空间
     */

    // 定义递归函数功能：求出当前结点的
    public int maxDepth(TreeNode root) {
        // 递归终止
        if (root == null) {
            return 0;
        }
        // dfs，先递归左子结点，再递归右子结点，最后求出每一子树的深度的最大值
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * 层序遍历
     * <p>
     * 时间复杂度 O(N)：平均需要遍历所有结点
     * 空间复杂度 O(1)：用到了队列，N为队列长度
     */
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        // 队列，每次while循环保存当前层的所有结点
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.add(root);
        // 遍历每一层
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层每个结点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 记录层数
            res++;
        }
        return res;
    }
}

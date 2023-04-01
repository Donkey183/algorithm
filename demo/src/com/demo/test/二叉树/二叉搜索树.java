package com.demo.test.二叉树;

public class 二叉搜索树 {
    int pre = Integer.MIN_VALUE;

    //中序遍历

    /**
     * 二叉搜索树的特性就是中序遍历是递增序。既然是判断是否是二叉搜索树，那我们可以使用中序递归遍历。
     * 只要之前的节点是二叉树搜索树，那么如果当前的节点小于上一个节点值那么就可以向下判断。
     * *只不过在过程中我们要求反退出。比如一个链表1->2->3->4，只要for循环遍历如果中间有不是递增的直接返回false即可。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        //先进入左子树
        if (!isValidBST(root.left))
            return false;
        if (root.val < pre)
            return false;
        //更新最值
        pre = root.val;
        //再进入右子树
        return isValidBST(root.right);
    }
}

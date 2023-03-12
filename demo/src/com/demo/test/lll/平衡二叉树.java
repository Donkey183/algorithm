package com.demo.test.lll;

public class 平衡二叉树 {
    /**
     * 平衡二叉树的左右子树也是平衡二叉树，那么所谓平衡就是左右子树的高度差不超过1.
     *
     * @param root
     * @return
     */
    public int depth(二叉树.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1; //如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        }

        int right = depth(root.right);
        if (right == -1) {
            return -1;//如果发现子树不平衡之后就没有必要进行下面的高度的求解了
        }

        if (left - right < (-1) || left - right > 1) {
            return -1;
        } else {
            return 1 + (left > right ? left : right);
        }
    }

    public boolean IsBalanced_Solution(二叉树.TreeNode root) {
        return depth(root) != -1;
    }
}
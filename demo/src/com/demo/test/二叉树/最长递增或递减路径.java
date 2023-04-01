package com.demo.test.二叉树;

public class 最长递增或递减路径 {
    int result = 0;

    public int longestConsecutive(TreeNode root) {
        postOrder(root);
        return result;
    }

    /**
     * arr数组表示递增或者递减：arr[0]表示递减，arr[1]表示递增
     */
    public int[] postOrder(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) {
            return arr;
        }
        arr[0] = 1;
        arr[1] = 1;
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        if (root.left != null) {
            if (root.left.val + 1 == root.val) {
                arr[0] = left[0] + 1;
            } else if (root.left.val - 1 == root.val) {
                arr[1] = left[1] + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val + 1 == root.val) {
                arr[0] = right[0] + 1;
            } else if (root.right.val - 1 == root.val) {
                arr[1] = right[1] + 1;
            }
        }
        result = Math.max(result, arr[0] + arr[1] - 1);  //要么递增，要么递减，另一个就是1
        return arr;
    }
}

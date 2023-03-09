package com.demo.test.lll;

import java.util.*;

public class 二叉树 {

  /**
   * 水平打印二叉树
   */
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList();//用于返回最后的结果
    if (root == null) {
      return res;//如果根节点为空就返回结果
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();//用于存储每一层的节点
    queue.add(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      ArrayList<Integer> temp = new ArrayList<>();//用于存储当前遍历这一层的节点
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();//取出队列的第一个元素
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
  public static List<List<Integer>> zLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    if (root == null) {
      return ans;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);
    boolean isOrderLeft = true;

    while (!nodeQueue.isEmpty()) {
      Deque<Integer> levelList = new LinkedList<Integer>();
      int size = nodeQueue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = nodeQueue.poll();
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

  public void inorder(TreeNode root, List<Integer> list) {
    if (root != null) {
      inorder(root.left, list);
      list.add(root.val);
      System.out.println("inorder:" + root.val);
      inorder(root.right, list);
    }
  }

  public void postorder(TreeNode root, List<Integer> list) {
    if (root != null) {
      postorder(root.left, list);
      postorder(root.right, list);
      list.add(root.val);
      System.out.println("postorder:" + root.val);
    }
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
      val = x;
    }
  }

  private static TreeNode initTree() {
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
   *
   * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
   *
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
   *
   * 叶子节点 是指没有子节点的节点。
   *
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
//    levelTraverse(root);
//    List<List<Integer>> result = zLevelOrder(root);
//    for (List<Integer> list : result) {
//      StringBuilder sb = new StringBuilder();
//      for (Integer i : list) {
//        sb.append(i);
//        sb.append(",");
//      }
//      String printStr = sb.toString();
//      System.out.println(printStr.substring(0, printStr.length() - 1));
//    }

//    preOrderTraverse2(root);
//    List<Integer> list = new ArrayList<>();
//    preOrder(root, list);
//    for (Integer i : list) {
//      System.out.println(i);
//    }

    preOrder(root, new ArrayList<Integer>());
    System.out.println("maxDepth=" + maxDepth2(root));
    System.out.println("hasPathSum=" + hasPathSum(root, 101));
  }
}

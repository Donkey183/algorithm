package com.demo.test.lll;

import java.util.*;

public class Tree {
  
  /**
   * 水平打印二叉树
   *
   * @param root
   */
  private static void levelTraverse(TreeNode root) {
    if (root == null) {
      return;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode treeNode = queue.poll();
      System.out.println(treeNode.val);
      if (treeNode.left != null) {
        queue.offer(treeNode.left);
      }
      if (treeNode.right != null) {
        queue.offer(treeNode.right);
      }
    }
  }
  
  /**
   * z形打印二叉树
   *
   * @param root
   */
  private static List<List<Integer>> zPrint(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> s1 = new Stack<TreeNode>();
    Stack<TreeNode> s2 = new Stack<TreeNode>();
    s1.push(root);
    int layer = 1;
    while (!s1.isEmpty() || !s2.isEmpty()) {
      if (layer % 2 != 0) {
        List<Integer> temp = new ArrayList<>();
        while (!s1.isEmpty()) {
          TreeNode node = s1.pop();
          temp.add(node.val);
          System.out.println(node.val);
          if (node.left != null) {
            s2.push(node.left);
          }
          if (node.right != null) {
            s2.push(node.right);
          }
        }
        layer++;
        result.add(temp);
      } else {
        List<Integer> temp = new ArrayList<>();
        while (!s2.isEmpty()) {
          TreeNode node = s2.pop();
          System.out.println(node.val);
          if (node.right != null) {
            s1.push(node.right);
          }
          if (node.left != null) {
            s1.push(node.left);
          }
        }
        layer++;
        result.add(temp);
      }
    }
    return result;
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
  
  public static void main(String[] args) {
    TreeNode root = initTree();
    zPrint(root);
  }
  
}

package com.demo.test;

public class LinkList {
  private static Node head;
  private static Node current;
  
  public static void main(String[] args) {
    int a[] = {1, -1, 3, 7, 2};
    int b[] = {1, 2, 6};
    int c[] = {3, 7, 8, 9};
    
    Node bHead = init(b);
    Node cHead = init(c);
    merge(bHead, cHead);
    printList(head);
  }
  
  private static Node init(int[] a) {
    Node head = null;
    Node current = null;
    for (int i = 0; i < a.length; i++) {
      //如果头结点为空,为头结点
      if (head == null) {
        head = new Node(a[i]);
        current = head;
      } else {
        current.next = new Node(a[i]);
        current = current.next;
      }
    }
    return head;
  }
  
  private static Node reverse(Node head) {
    Node newHead = null;
    return reverse(head, newHead);
  }
  
  public static Node reverse(Node head, Node newHead) {
    if (head == null) {
      return newHead;
    }
    Node next = head.next;
    head.next = newHead;
    newHead = head;
    head = next;
    return reverse(head, newHead);
  }
  
  public static Node reverse2(Node head) {
    Node newHead = null;
    while (head != null) {
      Node next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }
  
  
  // 往链表中添加数据
  private static void addData(int data) {
    if (head == null) {
      head = new Node(data); // 如果头节点为空，就新建一个头结点
      current = head; // 记录当前节点为头结点
    } else {
      current.next = new Node(data); // 新建一个节点，当前节点的指针域指向它
      current = current.next; // 当前节点位置后移
    }
  }
  
  // 打印链表
  private static void printList(Node head) {
    if (head != null) { // 确定链表不为空
      current = head;
      while (current != null) { // 最后一个节点的为空
        System.out.print(current.value + "-->");
        current = current.next; // 当前节点往后移动一个位置
      }
    }
  }
  
  private static Node merge(Node head1, Node head2) {
    Node newHead = null;
    if (head1 == null) {
      return head2;
    }
    if (head2 == null) {
      return head1;
    }
    while (head1 != null && head2 != null) {
      if (head1.value > head2.value) {
        addData(head2.value);
        head2 = head2.next;
      } else {
        addData(head1.value);
        head1 = head1.next;
      }
    }
    while (head1 != null) {
      addData(head1.value);
      head1 = head1.next;
    }
    while (head2 != null) {
      addData(head2.value);
      head2 = head2.next;
    }
    return newHead;
  }
  
  public static class Node {
    private int value;
    private Node next;
    
    public Node(int value) {
      this.value = value;
    }
  }
}

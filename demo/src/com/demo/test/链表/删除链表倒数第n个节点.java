package com.demo.test.链表;

public class 删除链表倒数第n个节点 {
    // 删除倒数第n个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null) {
            return null;
        }

        while (n > 0) {
            fast = fast.next;
            n--;
            if (n > 0 && fast == null) {
                return null;
            }
        }

        //如果n的值等于链表的长度,直接返回去掉头结点的链表
        if (fast == null) {
            return head.next;
        }

        ListNode result = slow;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;  // 关键步骤，删除操作
        return result;
    }
}

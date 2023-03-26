package com.demo.test.链表;

public class 链表是否有环 {
    // 链表是否有环
    public static boolean hasCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.hashCode() == slow.hashCode()) {
                return true;
            }
        }
        return false;
    }
}

package com.demo.test.链表;

public class 反转链表 {

    /**
     * 非递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseNormal(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 递归方式
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        return reverse(head, newHead);
    }

    public static ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return reverse(head, newHead);
    }
}

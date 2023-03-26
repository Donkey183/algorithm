package com.demo.test.链表;

public class 合并两个有序链表 {
    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode head = new ListNode(-1);
        ListNode result = head;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                addNode(head, head1.value);
                head1 = head1.next;
            } else {
                addNode(head, head2.value);
                head2 = head2.next;
            }
            head = head.next;
        }
        while (head1 != null) {
            addNode(head, head1.value);
            head1 = head1.next;
            head = head.next;
        }
        while (head2 != null) {
            addNode(head, head2.value);
            head2 = head2.next;
            head = head.next;
        }
        return result.next;
    }

    private static void addNode(ListNode listNode, int value) {
        ListNode tail = new ListNode(value);
        listNode.next = tail;
    }
}

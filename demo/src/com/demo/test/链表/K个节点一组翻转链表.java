package com.demo.test.链表;

public class K个节点一组翻转链表 {
    /**
     * 给你链表的头节点 head ，每K个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverseK(a, k);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转链表前K个元素
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseK(ListNode head, int k) {
        ListNode newHead = null;
        while (head != null && k > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            k--;
        }
        return newHead;
    }
}

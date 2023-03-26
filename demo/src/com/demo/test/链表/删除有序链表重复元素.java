package com.demo.test.链表;

public class 删除有序链表重复元素 {
    /**
     * 删除有序链表重复元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null) return head;

        ListNode cur = head;

        while (head.next != null) {
            if (head.next.value == head.value) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return cur;
    }

    /**
     * 删除有序链表重复元素, 保留仅出现一次的元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.value == cur.next.next.value) {
                int val = cur.next.value;

                while (cur.next != null && cur.next.value == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}

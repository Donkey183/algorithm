package com.demo.test.链表;

public class 链表是否为回文结构 {

    /**
     * 可以使用快慢指针，快指针的速度为慢指针的两倍，当快指针到达链表尾部时，慢指针到达中间位置，
     * 将慢指针之后的部分进行反转，再与前半部分进行比较。
     * https://www.nowcoder.com/practice/3fed228444e740c8be66232ce8b87c2f?tpId=295&tqId=1008769&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     */
    public boolean isPail(ListNode head) {
        ListNode q = head, p = head;
        //通过快慢指针找到中点
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        //如果q不为空，说明链表的长度是奇数个
        if (q != null) {
            p = p.next;
        }
        //反转后半部分链表
        p = reverse(p);

        q = head;
        while (p != null) {
            //然后比较，判断节点值是否相等
            if (q.value != p.value) {
                return false;
            }
            q = q.next;
            p = p.next;
        }
        return true;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

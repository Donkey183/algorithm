package com.demo.test.链表;

public class 两条链表是否相交 {
    /**
     * 判断两个无环单链表是否相交
     * <p>
     * 如果两个链表相交，那么最后一个节点一定是共有的。
     * 所以可以得出另外一种解法，先遍历 A 链表，记住尾节点，然后遍历 B 链表，比较两个链表的尾节点，
     * 如果相同则相交，不同则不相交。时间复杂度为 O(Length(A) + Length(B))，空间复杂度为 O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public boolean isIntersect(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return false;
        }
        if (headA == headB) {
            return true;
        }
        while (null != headA.next) {
            headA = headA.next;
        }
        while (null != headB.next) {
            headB = headB.next;
        }
        return headA == headB;
    }
}

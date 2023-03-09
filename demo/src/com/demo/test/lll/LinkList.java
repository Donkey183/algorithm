package com.demo.test.lll;

public class LinkList {

    private static ListNode head;
    private static ListNode current;

    public static void main(String[] args) {
        int a[] = {1, -1, 3, 7, 2};
        int b[] = {1, 2, 6, 3, 5, 1};
        int c[] = {3, 7, 8, 9};
        int d[] = {1, 3, 5, 6};
        int e[] = {2, 4, 6, 8, 10, 12, 9, 10};
        int h[] = {1, 3, 5};
        int g[] = {1, 1, 1, 2, 3, 5, 6, 6, 6, 6, 7};

        ListNode dHead = init(d);
        ListNode eHead = init(e);
        ListNode hHead = init(h);
        ListNode gHead = init(g);
//    printList(removeNthFromEnd(hHead, 4));
//        printList(deleteDuplicates2(gHead));
        printList(reverseKGroup(eHead, 3));
//    System.out.println("hasCircle:" + hasCircle(bHead));
//    printList(merge2(dHead, eHead));
//    Node cHead = init(c);
    }

    private static ListNode init(int[] a) {
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < a.length; i++) {
            //如果头结点为空,为头结点
            if (head == null) {
                head = new ListNode(a[i]);
                current = head;
            } else {
                current.next = new ListNode(a[i]);
                current = current.next;
            }
        }
        return head;
    }

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

    public static ListNode reverse2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }



    // 往链表中添加数据
    private static void addData(int data) {
        if (head == null) {
            head = new ListNode(data); // 如果头节点为空，就新建一个头结点
            current = head; // 记录当前节点为头结点
        } else {
            current.next = new ListNode(data); // 新建一个节点，当前节点的指针域指向它
            current = current.next; // 当前节点位置后移
        }
    }

    // 打印链表
    private static void printList(ListNode head) {
        if (head != null) { // 确定链表不为空
            current = head;
            while (current != null) { // 最后一个节点的为空
                System.out.print(current.value + "-->");
                current = current.next; // 当前节点往后移动一个位置
            }
        }
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode newHead = null;
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


    private static ListNode merge2(ListNode head1, ListNode head2) {
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

    // 删除倒数第n个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || n <= 1) {
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

    /**
     * 给你链表的头节点 head ，每K个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
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
        if (head == null) return null;
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

    /**
     * 判断两个无环单链表是否相交
     *
     * 如果两个链表相交，那么最后一个节点一定是共有的。
     * 所以可以得出另外一种解法，先遍历 A 链表，记住尾节点，然后遍历 B 链表，比较两个链表的尾节点，
     * 如果相同则相交，不同则不相交。时间复杂度为 O(Length(A) + Length(B))，空间复杂度为 O(1)
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

    public static class ListNode {

        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}

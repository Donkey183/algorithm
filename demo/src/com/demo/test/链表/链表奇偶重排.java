package com.demo.test.链表;

public class 链表奇偶重排 {
    /**
     * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
     * 注意是节点的编号而非节点的数值。
     * https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=295&tqId=1073463&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        //如果链表为空，不用重排
        if (head == null) {
            return head;
        }

        //even开头指向第二个节点，可能为空
        ListNode even = head.next;
        //odd开头指向第一个节点
        ListNode odd = head;
        //指向even开头
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            //odd连接even的后一个，即奇数位
            odd.next = even.next;
            //odd进入后一个奇数位
            odd = odd.next;
            //even连接后一个奇数的后一位，即偶数位
            even.next = odd.next;
            //even进入后一个偶数位
            even = even.next;
        }
        //even整体接在odd后面
        odd.next = evenHead;
        return head;
    }
}



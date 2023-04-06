package com.demo.test.I;

import com.demo.test.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        findSum(5, 9);
    }

    public static ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            newHead = head.next;

            head = next;
        }
        return newHead;
    }
}

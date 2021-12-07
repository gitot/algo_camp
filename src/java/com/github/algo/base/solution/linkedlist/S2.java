package com.github.algo.base.solution.linkedlist;

public class S2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0, null);
        ListNode tail = p;

        int reminder = 0;
        while (l1 != null && l2 != null) {
            int addition = l1.val + l2.val + reminder;
            reminder = addition > 9 ? 1 : 0;
            tail.next = new ListNode(addition % 10, null);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int addition = reminder + l1.val;
            reminder = addition > 9 ? 1 : 0;
            tail.next = new ListNode(addition % 10, null);
            tail = tail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int addition = reminder + l2.val;
            reminder = addition > 9 ? 1 : 0;
            tail.next = new ListNode(addition % 10, null);
            tail = tail.next;
            l2 = l2.next;
        }

        if (reminder > 0) {
            tail.next = new ListNode(1, null);
        }

        return p.next;
    }
}

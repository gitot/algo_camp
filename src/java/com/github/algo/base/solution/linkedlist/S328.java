package com.github.algo.base.solution.linkedlist;

public class S328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode bb = head.next;

        ListNode a = head;
        ListNode b = head.next;

        while (b != null && b.next != null) {
            a.next = b.next;
            b.next = a.next.next;

            a = a.next;
            b = b.next;
        }

        a.next = bb;

        return head;
    }
}

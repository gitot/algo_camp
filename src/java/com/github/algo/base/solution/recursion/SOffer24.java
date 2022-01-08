package com.github.algo.base.solution.recursion;

import com.github.algo.base.solution.linkedlist.ListNode;

public class SOffer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

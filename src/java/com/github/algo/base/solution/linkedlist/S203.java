package com.github.algo.base.solution.linkedlist;

public class S203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode hh = new ListNode(0, head);
        ListNode prev = hh;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return hh.next;
    }

}

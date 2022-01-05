package com.github.algo.base.exercise;

import com.github.algo.base.solution.linkedlist.ListNode;

public class S19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //count nodes
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        //reuse same variable
        ListNode sentinel = new ListNode(0, head);
        cur = sentinel;
        int times = count - n;
        for (int i = 0; i < times; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return sentinel.next;
    }
}

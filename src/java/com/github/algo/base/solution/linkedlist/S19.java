package com.github.algo.base.solution.linkedlist;

public class S19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cnt++;
        }

        ListNode sentinel = new ListNode(0, head);

        ListNode cur = sentinel;
        for (int i = 0; i < cnt - n; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return sentinel.next;
    }

}

package com.github.algo.base.solution.linkedlist;

public class SOffer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;

        //count elements in the linked list
        int cnt = 0;
        while (p != null) {
            p = p.next;
            cnt++;
        }

        if (cnt < k) return null;


        //move to the target node
        p = head;
        for (int i = 0; i < cnt - k; i++) {
            p = p.next;
        }

        return p;
    }
}

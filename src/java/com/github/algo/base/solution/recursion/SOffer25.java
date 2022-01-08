package com.github.algo.base.solution.recursion;

import com.github.algo.base.solution.linkedlist.ListNode;

public class SOffer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            ListNode listNode = mergeTwoLists(l1.next, l2);
            l1.next = listNode;
            return l1;
        } else {
            ListNode listNode = mergeTwoLists(l1, l2.next);
            l2.next = listNode;
            return l2;
        }
    }
}

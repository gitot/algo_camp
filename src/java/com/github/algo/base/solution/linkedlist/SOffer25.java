package com.github.algo.base.solution.linkedlist;

public class SOffer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0, null);
        ListNode tail = pre;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            } else if (l1.val > l2.val) {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            } else {
                tail.next = l1;
                l1 = l1.next;
                tail.next.next = l2;
                l2 = l2.next;
                tail = tail.next.next;
            }
        }

        if (l1 == null && l2 != null) {
            tail.next = l2;
        } else if (l1 != null && l2 == null) {
            tail.next = l1;
        }

        return pre.next;
    }


}

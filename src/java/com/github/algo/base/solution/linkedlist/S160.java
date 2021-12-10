package com.github.algo.base.solution.linkedlist;

public class S160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //The two pointer will finally be equal,
        //either at the actual node at which the two linked list come across,
        //or at the end of each linked list.
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}

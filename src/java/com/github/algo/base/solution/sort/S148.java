package com.github.algo.base.solution.sort;

import com.github.algo.base.solution.linkedlist.ListNode;

public class S148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;//cut two sides off from each other
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(rightHead);

        //merge two sorted side
        ListNode newHead = merge(leftHalf, rightHalf);
        return newHead;
    }

    private ListNode merge(ListNode leftHalf, ListNode rightHalf) {
        if (leftHalf == null) {
            return rightHalf;
        }
        if (rightHalf == null) {
            return leftHalf;
        }
        if (leftHalf.val < rightHalf.val) {
            ListNode node = merge(leftHalf.next, rightHalf);
            leftHalf.next = node;
            return leftHalf;
        }else{
            ListNode node = merge(leftHalf, rightHalf.next);
            rightHalf.next = node;
            return rightHalf;
        }
    }
}

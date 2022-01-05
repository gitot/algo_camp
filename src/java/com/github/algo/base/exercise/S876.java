package com.github.algo.base.exercise;

import com.github.algo.base.solution.linkedlist.ListNode;

public class S876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

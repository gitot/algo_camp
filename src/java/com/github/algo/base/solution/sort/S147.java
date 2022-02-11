package com.github.algo.base.solution.sort;

import com.github.algo.base.solution.linkedlist.ListNode;

public class S147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE,null);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; //next node to be inserted

            ListNode c = res;
            while (c != null) {
                if (c.next == null) {
                    c.next = cur;
                    cur.next = null;//cut sorted left side from unsorted right side
                    break;
                }
                if (c.next.val > cur.val) {
                    cur.next = c.next;
                    c.next = cur;
                    break;
                }
                c = c.next;
            }

            cur = next;
        }

        return res.next;
    }
}

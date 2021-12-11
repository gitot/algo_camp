package com.github.algo.base.solution.linkedlist;

import com.github.algo.base.solution.linkedlist.test.Utils;

public class S25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(0, null);
        sentinel.next = head;
        ListNode tail = sentinel;

        while (tail != null && tail.next != null) {
            //find k elements
            int j = 0;
            ListNode t = tail;   //the tail at which the reversed list will be linked
            ListNode h = tail.next;  //the first node of the list that will be reversed
            for (; j < k; j++) {
                if (tail == null) break;
                tail = tail.next;
            }
            //At last ,tail points at the last node, null or actual node


            if (tail == null) {
                //return immediately if there is not enough nodes remain
                return sentinel.next;
            } else {
                //Reverse the current k nodes,
                //then link them to the finished work.
                //At last, prev will point at the head of the reversed list
                ListNode prev = null, cur = h,n = null;
                while (prev != tail) {
                    n = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = n;
                }

                t.next = tail;
                tail = h;
                tail.next = n;
            }
        }

        return sentinel.next;
    }


    public static void main(String[] args) {
        ListNode node = Utils.createNode("[1,2,3,4,5]");
        S25 s25 = new S25();
        ListNode listNode = s25.reverseKGroup(node, 2);
        System.out.println();
    }

}

package com.github.algo.base.solution.linkedlist;

import com.github.algo.base.solution.linkedlist.test.Utils;

public class S234 {
    public boolean isPalindrome(ListNode head) {
        //find the middle node
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //At last, slow is at the middle of the linked list

        //reverse the right half
        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        //At last, prev is the head of the new linked list
        //which comes from the right half of the origin one.


        //Note that the right part may be one node longer than the left part,
        //when there is odd number nodes.

        //We can just jump the extra node when we compare the two linked list.
        //compare two half one by one
        ListNode lh = head;
        ListNode rh = prev;
        while (lh != null && rh != null) {
            if (lh.val != rh.val) {
                return false;
            }
            lh = lh.next;
            rh = rh.next;
        }

        return true;
    }

    public static void main(String[] args) {

        ListNode node = Utils.createNode("[1,2,2,1]");
        S234 s = new S234();
        System.out.println(s.isPalindrome(node));
    }

}

package com.github.algo.base.solution.linkedlist;

public class S25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        //1.find continual k elements
        //2.reverse these k  elements
        //3.link the reversed elements to the left
        //Loop from step 1 to step 3, util there is not enough elements remain on the right
        ListNode sentinel = new ListNode(0, null);
        ListNode tail = head;
        sentinel.next = tail;

        while (tail != null) {
            //find k elements
            int i = k - 1;
            for (int j = 0; j < i; j++) {
                if (tail == null)
                tail = tail.next;
            }

            //todo


            //break if there is no more k elements remains


            //reverse these k elements


        }

        return sentinel.next;
    }

}

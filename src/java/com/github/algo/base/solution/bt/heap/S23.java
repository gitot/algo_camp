package com.github.algo.base.solution.bt.heap;

import com.github.algo.base.solution.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode tail = head;

        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        int len = lists.length;
        for (int i = 0; i < len; i++) {
            ListNode list = lists[i];
            if (list == null) continue;
            queue.offer(list);
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = poll;

            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }

        return head.next;
    }


}

package com.github.algo.base.solution.linkedlist.test;

import com.github.algo.base.solution.linkedlist.ListNode;

public class Utils {
    public static ListNode createNode(String str) {
        String[] split = str.replace("[", "").replaceAll("]", "").split(",");
        ListNode hh = new ListNode(0, null);
        ListNode tail = hh;
        for (String s : split) {
            int i = Integer.parseInt(s.trim());
            tail.next = new ListNode(i, null);
            tail = tail.next;
        }
        return hh.next;
    }

    public static void main(String[] args) {
        ListNode node = createNode("[1,2,2,1]");
        System.out.println();
    }
}

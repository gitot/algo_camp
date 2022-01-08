package com.github.algo.base.solution.recursion;

import com.github.algo.base.solution.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SOffer06 {
    private List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        recurse(head);

        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void recurse(ListNode head) {
        if (head.next != null) recurse(head.next);

        list.add(head.val);
    }
}

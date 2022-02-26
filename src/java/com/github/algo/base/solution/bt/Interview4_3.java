package com.github.algo.base.solution.bt;

import com.github.algo.base.solution.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Interview4_3 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while (!queue.isEmpty()) {
            //construct a new linked list for this level,
            // then add to result.
            ListNode sentinel = new ListNode();
            ListNode tail = sentinel;
            int size = queue.size();// the node counts on this level
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tail.next = new ListNode(poll.val);
                tail = tail.next;
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            list.add(sentinel.next);
        }

        ListNode[] res = new ListNode[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

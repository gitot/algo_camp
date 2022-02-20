package com.github.algo.base.solution.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll == null) continue;
                list.add(poll.val);
                if (poll.children == null || poll.children.size() <= 0) continue;
                for (Node child : poll.children) queue.offer(child);
            }
            res.add(list);
        }
        return res;
    }

}

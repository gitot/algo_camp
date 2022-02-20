package com.github.algo.base.solution.bt;

import java.util.ArrayList;
import java.util.List;

public class S590 {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        List<Node> children = root.children;
        int size = children.size();
        for (int i = 0; i < size; i++) {
            List<Integer> postorder = postorder(children.get(i));
            if (postorder == null) continue;
            res.addAll(postorder);
        }

        res.add(root.val);
        return res;
    }
}

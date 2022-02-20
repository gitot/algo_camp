package com.github.algo.base.solution.bt;

import java.util.List;

public class S559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> children = root.children;
        int res = 0;
        for (Node child : children) {
            res = Math.max(maxDepth(child), res);
        }
        return res + 1;
    }
}

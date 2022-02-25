package com.github.algo.base.solution.bt;

import com.github.algo.base.solution.tree.TreeNode;

public class S114 {

    TreeNode sentinel = new TreeNode();
    TreeNode tail = sentinel;

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;

        tail.right = root;
        tail.left = null;
        tail = root;

        flatten(left);
        flatten(right);
    }
}

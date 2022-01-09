package com.github.algo.base.everyday;

import com.github.algo.base.solution.tree.TreeNode;

public class S617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode root = new TreeNode(0);
        root.val = root1.val + root2.val;

        TreeNode left = mergeTrees(root1.left, root2.left);
        root.left = left;
        TreeNode right = mergeTrees(root1.right, root2.right);
        root.right = right;

        return root;
    }
}
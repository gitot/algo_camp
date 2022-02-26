package com.github.algo.base.solution.bt;

public class S617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode node = new TreeNode();

        if (root1 == null) {
            node.val += root2.val;
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        } else if (root2 == null) {
            node.val += root1.val;
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        } else {
            node.val += root1.val;
            node.val += root2.val;
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        }

        return node;
    }
}

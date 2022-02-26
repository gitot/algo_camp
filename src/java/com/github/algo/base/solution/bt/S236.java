package com.github.algo.base.solution.bt;

public class S236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        if (leftLca == null) return rightLca;
        if (rightLca == null) return leftLca;
        return root;
    }
}

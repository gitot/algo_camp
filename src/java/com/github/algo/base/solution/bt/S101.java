package com.github.algo.base.solution.bt;

public class S101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isSymmetric = recurse(root.left, root.right);
        return isSymmetric;
    }

    private boolean recurse(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        boolean a = recurse(left.left, right.right);
        boolean b = recurse(left.right, right.left);
        return a && b;
    }
}

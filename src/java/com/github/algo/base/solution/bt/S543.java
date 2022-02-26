package com.github.algo.base.solution.bt;

public class S543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calHeight(root);
        return res;
    }

    private int calHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = calHeight(root.left);
        int rightHeight = calHeight(root.right);
        int diameter = leftHeight + rightHeight;
        if (diameter > res) res = diameter;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

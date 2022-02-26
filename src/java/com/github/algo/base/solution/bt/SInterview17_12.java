package com.github.algo.base.solution.bt;

public class SInterview17_12 {

    TreeNode head = new TreeNode();
    TreeNode tail = head;

    public TreeNode convertBiNode(TreeNode root) {
        preOrder(root);
        return head.right;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;

        preOrder(root.left);

        root.left = null;
        tail.right = root;
        tail = tail.right;

        preOrder(root.right);
    }
}

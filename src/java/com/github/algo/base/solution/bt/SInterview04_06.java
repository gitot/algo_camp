package com.github.algo.base.solution.bt;

import com.github.algo.base.solution.tree.TreeNode;

public class SInterview04_06 {
    TreeNode successor;
    private boolean coming;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        dfs(root,p);
        return successor;
    }

    /**
     * return if successor has been found.
     *
     */
    void dfs(TreeNode node,TreeNode p) {
        if (node == null) {
            return;
        }
        dfs(node.left,p);
        if (successor != null) {
            return;
        }
        if (coming) {
            successor = node;
//            coming = false;
            return;
        }
        if (node == p) {
            coming = true;
        }
        dfs(node.right,p);
    }
}

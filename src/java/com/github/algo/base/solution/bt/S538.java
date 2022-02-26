package com.github.algo.base.solution.bt;

import com.github.algo.base.solution.tree.TreeNode;

public class S538 {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}

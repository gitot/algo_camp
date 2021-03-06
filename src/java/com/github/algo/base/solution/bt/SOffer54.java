package com.github.algo.base.solution.bt;

public class SOffer54 {
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k ==0) res = root.val;
        dfs(root.left);
    }

}

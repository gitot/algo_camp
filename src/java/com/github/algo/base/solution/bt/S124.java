package com.github.algo.base.solution.bt;

public class S124 {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        int max = root.val;
        if (leftMax > 0) max += leftMax;
        if (rightMax > 0) max += rightMax;
        if (max > res) res = max;


        int ret = root.val;

        if (ret < leftMax + root.val) ret = leftMax + root.val;
        if (ret < rightMax + root.val) ret = rightMax + root.val;
        return ret;
    }
}

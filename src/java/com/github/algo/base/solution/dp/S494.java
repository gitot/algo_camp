package com.github.algo.base.solution.dp;

public class S494 {
    public int findTargetSumWays(int[] nums, int target) {
        int offset = 1000;
        int w = 2000;
        int len = nums.length;
        int[][] dp = new int[len][w + 1];

        dp[0][offset + nums[0]] += 1;
        dp[0][offset - nums[0]] += 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= w; j++) {
                if (j - nums[i] >= 0 && j - nums[i] <= w) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] >= 0 && j + nums[i] <= w) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }

        return dp[len - 1][target + offset];
    }

    public static void main(String[] args) {
        new S494().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 1000}, -1000);
    }
}

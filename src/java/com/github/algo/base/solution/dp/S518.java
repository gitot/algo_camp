package com.github.algo.base.solution.dp;

public class S518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int c = 0; c <= amount / coins[0]; c++) {
            dp[0][c * coins[0]] = c;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int k = amount / coins[i];
                for (int c = 0; c <= k; c++) {
                    dp[i][j] += dp[i - 1][j - c * coins[i]];
                }
            }
        }

        return dp[n - 1][amount];
    }
}

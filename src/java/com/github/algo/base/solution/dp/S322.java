package com.github.algo.base.solution.dp;

public class S322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int c = 0; c <= amount / coins[0]; c++) {
            dp[0][c * coins[0]] = c;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int max = amount / coins[i];
                for (int c = 0; c <= max; c++) {
                    if (j - c * coins[i] >= 0
                            && dp[i - 1][j - c * coins[i]] != Integer.MAX_VALUE
                            && dp[i - 1][j - c * coins[i]] + c < dp[i][j]
                    ) {
                        dp[i][j] = dp[i - 1][j - c * coins[i]] + c;
                    }
                }
            }
        }

        if (dp[n - 1][amount] == Integer.MAX_VALUE) return -1;
        return dp[n - 1][amount];
    }
}

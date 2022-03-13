package com.github.algo.base.solution.dp;

import java.util.List;

public class S120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][i] = triangle.get(i).get(i) + dp[i - 1][i - 1];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] < res) {
                res = dp[n - 1][i];
            }
        }

        return res;
    }
}

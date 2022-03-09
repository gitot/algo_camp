package com.github.algo.base.solution.dp;

public class S416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        sum /= 2;

        boolean[][] state = new boolean[nums.length][sum + 1];
        state[0][0] = true;
        if (nums[0] <= sum) {
            state[0][nums[0]] = true;
        }

        for (int i = 1; i < state.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i] >= 0) {
                    state[i][j] = state[i - 1][j - nums[i]] || state[i - 1][j];
                } else {
                    state[i][j] = state[i - 1][j];
                }
            }
        }
        return state[nums.length - 1][sum];
    }
}

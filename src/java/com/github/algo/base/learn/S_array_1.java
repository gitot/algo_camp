package com.github.algo.base.learn;

public class S_array_1 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] tmp = new int[k];
        for (int i = nums.length - 1, j = k - 1; j >= 0; i--, j--) {
            tmp[j] = nums[i];
        }

        for (int i = nums.length - k - 1; i >= 0; i++) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tmp[i];
        }
    }
}

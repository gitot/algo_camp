package com.github.algo.base.solution.sort;

import java.util.Arrays;

public class S215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

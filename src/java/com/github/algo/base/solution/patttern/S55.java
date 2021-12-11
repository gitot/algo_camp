package com.github.algo.base.solution.patttern;

public class S55 {
    public boolean canJump(int[] nums) {
        int reachedMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachedMax) {
                return false;
            }
            if (nums[i] + i > reachedMax) {
                reachedMax = nums[i] + i;
            }
            if (reachedMax >= nums.length - 1) {
                return true;
            }
        }
        return reachedMax >= nums.length - 1;
    }

}

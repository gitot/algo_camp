package com.github.algo.base.solution.sort;

public class SOffer21 {
    public int[] exchange(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (needBubble(nums, j)) {
                    int tmp = nums[j+1];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }

    private boolean needBubble(int[] nums, int j) {
        return nums[j] % 2 == 0 && nums[j + 1] % 2 == 1;
    }
}

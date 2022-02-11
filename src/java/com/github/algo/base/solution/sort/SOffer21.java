package com.github.algo.base.solution.sort;

public class SOffer21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int left = 0,right = len - 1;
        while (left < right) {
            if (nums[left] % 2 != 0) {
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }

}

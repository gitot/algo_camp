package com.github.algo.base.exercise;

//Cannot understand this solution? Why?
public class S283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;  //the position at which the first 0 is located
        int right = 0;

        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


}

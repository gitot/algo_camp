package com.github.algo.base.solution.bs;

public class S35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && nums[mid] >= target) {
                return mid;
            } else if (mid == len - 1 && nums[mid] < target) {
                return len;
            } else if (nums[mid] >= target && nums[mid - 1] < target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

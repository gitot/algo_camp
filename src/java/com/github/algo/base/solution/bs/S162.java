package com.github.algo.base.solution.bs;

public class S162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        if (len == 1) return 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (mid == len - 1) {
                if (nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

package com.github.algo.base.solution.bs;

public class S153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (left == right) { // left == mid == right == 0
                    return nums[left];
                } else { //left == mid == 0 < right == 1
                    return nums[mid] < nums[right] ? nums[mid] : nums[right];
                }
            } else if (mid != 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] <= nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
